package me.aurium.beetle.defaults.task;

import me.aurium.beetle.api.task.SyncQueue;
import me.aurium.beetle.api.task.TaskRunner;
import me.aurium.beetle.api.task.Tasker;

import java.util.concurrent.*;

public abstract class AbstractTasker implements Tasker {

    private final SyncQueue syncQueue;
    private final ExecutorService asyncQueue;

    private final TaskRunner taskRunner;

    protected AbstractTasker(ExecutorService service) {
        this.syncQueue = new CommonSyncQueue();
        this.asyncQueue = service;

        this.taskRunner = new CommonTaskRunner(syncQueue,asyncQueue);
    }

    @Override
    public Executor getSyncExecutor() {
        return this.syncQueue;
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncQueue;
    }

    @Override
    public TaskRunner getRunner() {
        return this.taskRunner;
    }

    protected SyncQueue asQueue() {
        return this.syncQueue;
    }


}
