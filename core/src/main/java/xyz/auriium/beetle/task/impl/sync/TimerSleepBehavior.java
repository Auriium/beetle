package xyz.auriium.beetle.task.impl.sync;

import xyz.auriium.beetle.task.Comparisons;
import xyz.auriium.beetle.task.futures.SyncTaskerFuture;
import xyz.auriium.beetle.task.sync.SyncPulser;
import xyz.auriium.beetle.task.sync.coordination.BlockingBehavior;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;

public class TimerSleepBehavior implements BlockingBehavior {

    private final int sleepTimer;

    public TimerSleepBehavior(int sleepTimer) {
        this.sleepTimer = sleepTimer;
    }

    public TimerSleepBehavior() {
        this.sleepTimer = 200;
    }

    @Override
    public <T> T waitForJoin(SyncTaskerFuture<T> future, SyncPulser pulser) {
        while (true) {
            pulser.pulse();

            T result;
            if ((result = Comparisons.reportJoin(future)) != Comparisons.CONSTANT) {
                return result;
            }

            LockSupport.parkNanos(this, sleepTimer);
        }
    }

    @Override
    public <T> T waitForGet(SyncTaskerFuture<T> future, SyncPulser pulser) throws InterruptedException, ExecutionException {
        while (true) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }

            pulser.pulse();

            T result;
            if ((result = Comparisons.reportGet(future)) != Comparisons.CONSTANT) {
                return result;
            }

            LockSupport.parkNanos(this, sleepTimer);
        }
    }

    @Override
    public <T> T waitForTimer(SyncTaskerFuture<T> future, SyncPulser pulser, TimeUnit waitType, long waitDuration) throws InterruptedException, TimeoutException, ExecutionException {
        long deadline = System.nanoTime() + waitType.toNanos(waitDuration);

        while (true) {

            if (Thread.interrupted()) {
                throw new InterruptedException();
            }

            pulser.pulse();

            T result;
            if ((result = Comparisons.reportGet(future)) != Comparisons.CONSTANT) {
                return result;
            }

            long delay = deadline - System.nanoTime();

            if (delay <= 0) {
                throw new TimeoutException();
            }

            long parkFor = Math.min(delay, sleepTimer);
            LockSupport.parkNanos(this, parkFor);

            if (delay == parkFor && deadline - System.nanoTime() <= 0) {
                throw new TimeoutException();
            }
        }

    }
}
