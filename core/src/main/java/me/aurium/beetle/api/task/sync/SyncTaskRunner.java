package me.aurium.beetle.api.task.sync;

import me.aurium.beetle.api.task.TaskRunner;

import java.util.function.Supplier;

public interface SyncTaskRunner extends TaskRunner {

    /**
     * Runs a task asynchronously based on the platform's default executor
     * @param runnable runnable to run
     */
    @Override
    void executeAsync(Runnable runnable);

    /**
     * Supplies a CompletableFuture asynchronously using the platform's default executor
     * @param supplier the supplier
     * @param <T> type of object to return
     * @return a completablefuture containin the type
     */
    @Override
    <T> SyncFuture<T> supplyAsync(Supplier<T> supplier);

    /**
     * Runs a task on the main thread based on the platform's default executor
     * @param runnable runnable to run
     */
    void executeSync(Runnable runnable);

    /**
     * Supplies a CompletableFuture on the main thread using the platform's default executor for the thread
     * @param supplier supplier
     * @param <T> object to return
     * @return a completablefuture wi the type
     */
    <T> SyncFuture<T> supplySync(Supplier<T> supplier);
}