package me.aurium.beetle.defaults.task.sync;

import me.aurium.beetle.api.task.sync.*;

import java.util.concurrent.Executor;

public abstract class MainThreadTasker implements SyncTasker {

    private final Thread mainThread;
    private final SyncExecutorProvider provider;
    private final SyncTaskRunner taskRunner;
    private final SyncQueue queue;

    protected MainThreadTasker(Thread mainThread, Executor asyncExecutor, TaskCoordinator behavior) {
        this.mainThread = mainThread;

        this.queue = new CommonSyncQueue();
        this.provider = new MainThreadExecutorProvider(asyncExecutor, queue);
        this.taskRunner = new MainThreadRunner(behavior, queue,asyncExecutor,mainThread);
    }

    @Override
    public SyncTaskRunner getRunner() {
        return taskRunner;
    }

    @Override
    public SyncExecutorProvider exposeExecutors() {
        return provider;
    }

    @Override
    public Thread getMainThread() {
        return mainThread;
    }

    protected SyncQueue getQueue() {
        return this.queue;
    }


}
