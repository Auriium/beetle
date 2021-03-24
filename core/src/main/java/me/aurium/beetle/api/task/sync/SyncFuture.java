package me.aurium.beetle.api.task.sync;

import me.aurium.beetle.api.task.TaskFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * i want to stop existing
 *
 * A safer to use Future that permits get and join based on an internal behavior.
 *
 * TODO eventually some sort of resync to main thread functionality
 *
 * @param <T>
 */
public class SyncFuture<T> extends TaskFuture<T> {

    private final TaskCoordinator coordinator;

    public SyncFuture(TaskCoordinator coordinator) {
        this.coordinator = coordinator;
    }


    @Override
    public T get(long amount, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        if (coordinator.isMainThread()) {
            if (!super.getNow(SyncConstants.CONSTANT()).equals(SyncConstants.CONSTANT())) {
                return super.getNow(null);
            }

            return coordinator.waitFor(this,unit,amount);
        }

        return super.get(amount,unit);
    }

    @Override
    public T get() throws ExecutionException, InterruptedException {
        if (coordinator.isMainThread()) {
            if (!super.getNow(SyncConstants.CONSTANT()).equals(SyncConstants.CONSTANT())) {
                return super.getNow(null);
            }

            return coordinator.waitFor(this);
        }

        return super.get();
    }

    @Override
    public T join() {

        if (coordinator.isMainThread()) {
            if (!super.getNow(SyncConstants.CONSTANT()).equals(SyncConstants.CONSTANT())) {
                return super.getNow(null);
            }

            return coordinator.waitFor(this);
        }

        return super.join();
    }

}
