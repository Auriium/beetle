package me.aurium.beetle.defaults.task;

import me.aurium.beetle.api.task.SyncQueue;
import me.aurium.beetle.api.task.TaskFutureException;
import me.aurium.beetle.api.task.TaskRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class CommonTaskRunner implements TaskRunner {

    private final Executor asyncQueue;
    private final Executor syncQueue;

    public CommonTaskRunner(Executor syncQueue, Executor asyncQueue) {
        this.asyncQueue = asyncQueue;
        this.syncQueue = syncQueue;
    }

    @Override
    public void executeSync(Runnable runnable) {
        supplySync(() -> {
            runnable.run();

            return null;
        }).whenComplete((ignored,exception) -> {
            if (exception != null) {
                throw new TaskFutureException(exception);
            }
        });
    }

    @Override
    public void executeAsync(Runnable runnable) {
        supplyAsync(() -> {
            runnable.run();

            return null;
        }).whenComplete((ignored,exception) -> {
            if (exception != null) {
                throw new TaskFutureException(exception);
            }
        });
    }

    @Override
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier,asyncQueue);
    }

    @Override
    public <T> CompletableFuture<T> supplySync(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier,syncQueue);
    }

}
