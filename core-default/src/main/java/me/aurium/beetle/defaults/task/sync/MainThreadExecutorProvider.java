package me.aurium.beetle.defaults.task.sync;

import me.aurium.beetle.api.task.sync.SyncExecutorProvider;
import me.aurium.beetle.api.task.sync.SyncQueue;

import java.util.concurrent.Executor;

public class MainThreadExecutorProvider implements SyncExecutorProvider {

    private final Executor asyncExecutor;
    private final SyncQueue syncQueue;

    public MainThreadExecutorProvider(Executor asyncExecutor, SyncQueue syncQueue) {
        this.asyncExecutor = asyncExecutor;
        this.syncQueue = syncQueue;
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor;
    }

    @Override
    public Executor getSyncExecutor() {
        return syncQueue;
    }
}
