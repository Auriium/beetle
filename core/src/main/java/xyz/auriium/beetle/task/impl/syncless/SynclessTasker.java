package xyz.auriium.beetle.task.impl.syncless;

import xyz.auriium.beetle.task.ExecutorProvider;
import xyz.auriium.beetle.task.TaskRunner;
import xyz.auriium.beetle.task.Tasker;

import java.util.concurrent.ExecutorService;

public class SynclessTasker implements Tasker {

    private final ExecutorProvider synclessProvider;
    private final TaskRunner synclessTaskRunner;

    public SynclessTasker(ExecutorService asyncService) {
        this.synclessProvider = new SynclessExecutorProvider(asyncService);
        this.synclessTaskRunner = new SynclessTaskRunner(synclessProvider);
    }

    @Override
    public TaskRunner getRunner() {
        return synclessTaskRunner;
    }

    @Override
    public ExecutorProvider exposeExecutors() {
        return synclessProvider;
    }
}
