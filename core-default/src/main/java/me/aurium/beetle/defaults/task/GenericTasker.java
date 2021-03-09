package me.aurium.beetle.defaults.task;

import me.aurium.beetle.api.task.TaskQueue;
import me.aurium.beetle.api.task.TaskRunner;
import me.aurium.beetle.api.task.Tasker;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
