package me.aurium.beetle.task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public class GenericTaskRunner implements TaskRunner {

    private final ExecutorService service;
    private final TaskQueue queue;

    public GenericTaskRunner(TaskQueue queue, ExecutorService service) {
        this.service = service;
        this.queue = queue;
    }

    @Override
    public void runTaskSync(Runnable runnable) {
        queue.add(runnable);
    }

    @Override
    public void runTaskAsync(Runnable runnable) {
        service.submit(runnable);
    }

    @Override
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier,service);
    }

}
