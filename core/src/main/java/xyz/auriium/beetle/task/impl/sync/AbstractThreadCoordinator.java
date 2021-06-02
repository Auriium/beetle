package xyz.auriium.beetle.task.impl.sync;

import xyz.auriium.beetle.task.futures.SyncTaskerFuture;
import xyz.auriium.beetle.task.impl.sync.util.CommonSyncPulser;
import xyz.auriium.beetle.task.sync.SyncExecutorProvider;
import xyz.auriium.beetle.task.sync.coordination.BlockingBehavior;
import xyz.auriium.beetle.task.sync.coordination.TaskCoordinator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AbstractThreadCoordinator implements TaskCoordinator {

    //someone else can handle the main thread check because i give no shits (let implementer handle)
    //sadly, the implementer is usually me

    private final BlockingBehavior behavior;
    private final CommonSyncPulser pulser;

    protected AbstractThreadCoordinator(BlockingBehavior behavior, SyncExecutorProvider provider) {
        this.behavior = behavior;

        this.pulser = new CommonSyncPulser(provider.getSyncExecutor());
    }

    @Override
    public <T> T waitForJoin(SyncTaskerFuture<T> future) {
        return behavior.waitForJoin(future,pulser);
    }

    @Override
    public <T> T waitForGet(SyncTaskerFuture<T> future) throws InterruptedException, ExecutionException {
        return behavior.waitForGet(future,pulser);
    }

    @Override
    public <T> T waitForTimer(SyncTaskerFuture<T> future, TimeUnit waitType, long waitDuration) throws InterruptedException, TimeoutException, ExecutionException {
        return behavior.waitForTimer(future,pulser,waitType,waitDuration);
    }
}
