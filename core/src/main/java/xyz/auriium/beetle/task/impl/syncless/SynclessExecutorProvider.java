package xyz.auriium.beetle.task.impl.syncless;

import xyz.auriium.beetle.task.ExecutorProvider;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class SynclessExecutorProvider implements ExecutorProvider {

    private final ExecutorService asyncExecutor;

    public SynclessExecutorProvider(ExecutorService asyncExecutor) {
        this.asyncExecutor = asyncExecutor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor;
    }
}
