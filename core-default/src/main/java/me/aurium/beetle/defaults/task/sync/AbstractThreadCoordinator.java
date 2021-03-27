package me.aurium.beetle.defaults.task.sync;

import me.aurium.beetle.api.task.futures.SyncTaskerFuture;
import me.aurium.beetle.api.task.sync.SyncExecutorProvider;
import me.aurium.beetle.api.task.sync.coordination.BlockingBehavior;
import me.aurium.beetle.api.task.sync.coordination.TaskCoordinator;
import me.aurium.beetle.defaults.task.sync.util.CommonSyncPulser;

import java.util.concurrent.TimeUnit;

public abstract class AbstractThreadCoordinator implements TaskCoordinator {

    //someone else can handle the main thread check because i give no shits (let implementer handle)
    //sadly, the implementer is usually me

    private final BlockingBehavior behavior;
    private final CommonSyncPulser pulser;

    public AbstractThreadCoordinator(BlockingBehavior behavior, SyncExecutorProvider provider) {
        this.behavior = behavior;

        this.pulser = new CommonSyncPulser(provider.getSyncExecutor());
    }

    @Override
    public <T> T waitFor(SyncTaskerFuture<T> future) {
        return behavior.waitFor(future,pulser);
    }

    @Override
    public <T> T waitFor(SyncTaskerFuture<T> future, TimeUnit unit, long amount) {
        return behavior.waitFor(future,pulser,unit,amount);
    }
}
