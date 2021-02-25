package me.aurium.beetle.generic;

import me.aurium.beetle.core.task.CommonTaskQueue;
import me.aurium.beetle.core.task.TaskQueue;
import me.aurium.beetle.core.task.TaskRunner;
import me.aurium.beetle.core.task.Tasker;

import java.util.concurrent.*;

public class GenericTasker implements Tasker {

    private final TaskQueue taskQueue;
    private final TaskRunner taskRunner;
    private final ExecutorService executor;

    public GenericTasker() {
        this.executor = Executors.newFixedThreadPool(5000);
        this.taskQueue = new CommonTaskQueue();
        this.taskRunner = new GenericTaskRunner(taskQueue,executor);
    }

    public GenericTasker(ExecutorService service) {
        this.executor = service;
        this.taskQueue = new CommonTaskQueue();
        this.taskRunner = new GenericTaskRunner(taskQueue,executor);
    }

    @Override
    public TaskQueue getQueue() {
        return this.taskQueue;
    }

    @Override
    public TaskRunner getRunner() {
        return this.taskRunner;
    }

    @Override
    public void launch() {
        CompletableFuture.delayedExecutor(50L, TimeUnit.MICROSECONDS).execute(taskQueue::tick);
    }
}
