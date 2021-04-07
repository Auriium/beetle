package me.aurium.beetle.api.task.sync;

import me.aurium.beetle.api.task.Tasker;
import me.aurium.beetle.api.task.sync.coordination.TaskCoordinator;

public interface SyncTasker extends Tasker, AutoCloseable {

    @Override
    SyncTaskRunner getRunner();

    @Override
    SyncExecutorProvider exposeExecutors();

    TaskCoordinator exposeCoordinator();

}
