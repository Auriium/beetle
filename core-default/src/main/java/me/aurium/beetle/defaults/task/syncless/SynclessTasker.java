package me.aurium.beetle.defaults.task.syncless;

import me.aurium.beetle.api.task.ExecutorProvider;
import me.aurium.beetle.api.task.TaskRunner;
import me.aurium.beetle.api.task.Tasker;

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
