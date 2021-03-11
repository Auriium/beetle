package me.aurium.beetle.defaults.task;

import me.aurium.beetle.api.task.TaskQueue;
import me.aurium.beetle.api.task.Runner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public class GenericRunner implements Runner {

    private final ExecutorService service;
    private final TaskQueue queue;

    public GenericRunner(TaskQueue queue, ExecutorService service) {
        this.service = service;
        this.queue = queue;
    }

    @Override
    public void runRunnableSync(Runnable runnable) {
        queue.add(runnable);
    }

    @Override
    public void runRunnableAsync(Runnable runnable) {
        service.submit(runnable);
    }

    @Override
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier,service);
    }

}
