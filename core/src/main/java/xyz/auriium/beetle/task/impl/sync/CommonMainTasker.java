package xyz.auriium.beetle.task.impl.sync;

import xyz.auriium.beetle.task.sync.SyncExecutorProvider;
import xyz.auriium.beetle.task.sync.SyncTaskRunner;
import xyz.auriium.beetle.task.sync.SyncTasker;
import xyz.auriium.beetle.task.sync.coordination.TaskCoordinator;

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

    @Override
    public void close() throws Exception {
        provider.close();
    }
}
