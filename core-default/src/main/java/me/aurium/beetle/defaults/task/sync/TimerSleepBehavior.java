package me.aurium.beetle.defaults.task.sync;

import me.aurium.beetle.api.task.futures.SyncTaskerFuture;
import me.aurium.beetle.api.task.futures.TaskFuture;
import me.aurium.beetle.api.task.sync.coordination.BlockingBehavior;
import me.aurium.beetle.api.task.sync.coordination.SyncConstants;
import me.aurium.beetle.api.task.sync.SyncPulser;

import java.util.concurrent.TimeUnit;
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
    public <T> T waitFor(SyncTaskerFuture<T> future, SyncPulser pulser) {
        while (true) {
            pulser.pulse();

            T result;
            if (!(result = future.getNow(SyncConstants.CONSTANT())).equals(SyncConstants.CONSTANT())) {	// if (isDone()) {
                return result;										// return super.join(); }
            }

            LockSupport.parkNanos(this, sleepTimer);
        }
    }

    @Override
    public <T> T waitFor(SyncTaskerFuture<T> future, SyncPulser pulser, TimeUnit waitType, long waitDuration) {

        while (true) {
            pulser.pulse();

            T result;
            if (!(result = future.getNow(SyncConstants.CONSTANT())).equals(SyncConstants.CONSTANT())) {	// if (isDone()) {
                return result;										// return super.join(); }
            }

            LockSupport.parkNanos(this, sleepTimer);
        }

    }
}
