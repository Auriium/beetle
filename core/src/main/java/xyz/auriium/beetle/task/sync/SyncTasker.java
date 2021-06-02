package xyz.auriium.beetle.task.sync;

import xyz.auriium.beetle.task.Tasker;
import xyz.auriium.beetle.task.sync.coordination.TaskCoordinator;

public interface SyncTasker extends Tasker, AutoCloseable {

    @Override
    SyncTaskRunner getRunner();

    @Override
    SyncExecutorProvider exposeExecutors();

    TaskCoordinator exposeCoordinator();

}
