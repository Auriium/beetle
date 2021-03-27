package me.aurium.beetle.defaults.task.sync;

import me.aurium.beetle.api.task.sync.SyncExecutorProvider;
import me.aurium.beetle.api.task.sync.SyncTaskRunner;
import me.aurium.beetle.api.task.sync.SyncTasker;
import me.aurium.beetle.api.task.sync.coordination.TaskCoordinator;

public class CommonMainTasker implements SyncTasker {

    private final SyncExecutorProvider provider;
    private final TaskCoordinator coordinator;


    private final SyncTaskRunner runner;

    public CommonMainTasker(SyncExecutorProvider provider, TaskCoordinator coordinator) {
        this.provider = provider;
        this.coordinator = coordinator;

        this.runner = new CommonMainRunner(provider, coordinator);
    }


    @Override
    public SyncTaskRunner getRunner() {
        return runner;
    }

    @Override
    public SyncExecutorProvider exposeExecutors() {
        return provider;
    }

    @Override
    public TaskCoordinator exposeCoordinator() {
        return coordinator;
    }


}
