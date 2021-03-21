package me.aurium.beetle.api.task.sync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

/**
 * i want to stop existing
 *
 * A safer to use Future that permits get and join based on an internal behavior.
 *
 * TODO eventually some sort of resync to main thread functionality
 *
 * @param <T>
 */
public class SyncFuture<T> extends CompletableFuture<T> implements Synced {

    private final Thread mainThread;
    private final SyncQueue activeQueue;
    private final BlockingBehavior behavior;

    public SyncFuture(Thread mainThread, SyncQueue activeQueue, BlockingBehavior behavior) {
        this.mainThread = mainThread;
        this.activeQueue = activeQueue;
        this.behavior = behavior;
    }

    //TODO a248 i don't know if this is necessary but given that get operates on a similar principle (wait on the main thread if we are running sync)
    //i think it might be required. Anyways review this and see if it is necessary
    @Override
    public T get() throws ExecutionException, InterruptedException {
        if (isOnMainThread()) {
            while (!isDone()) {
                activeQueue.pulseQueue();

                if (isDone()) {
                    return super.get();
                }

                behavior.behavior();

            }
        }

        return super.get();
    }

    @Override
    public T join() {
        if (isOnMainThread()) {
            while (!isDone()) {
                activeQueue.pulseQueue(); //this is stepping in for the main sync-loop powered by the ticker timer
                //when this is finished the ticker timer should return to ticking its timer and automatically handling the queue

                if (isDone()) {
                    return super.join();
                }

                behavior.behavior();

            }
        }

        return super.join();
    }

    @Override
    public boolean isOnMainThread() {
        return mainThread.equals(Thread.currentThread());
    }
}
