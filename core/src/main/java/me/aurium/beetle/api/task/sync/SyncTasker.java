package me.aurium.beetle.api.task.sync;

import me.aurium.beetle.api.task.Tasker;

public interface SyncTasker extends Tasker {

    @Override
    SyncTaskRunner getRunner();

    @Override
    SyncExecutorProvider exposeExecutors();

    java.lang.Thread getMainThread();

    void launch();

}