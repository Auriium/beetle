package me.aurium.beetle.api.task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

/**
 * Marker interface that represents something that can run tasks overlaid onto the core.
 */
public interface TaskRunner {

    /**
     * Runs a task asynchronously based on the platform's default executor
     * @param runnable runnable to run
     */
    void executeAsync(Runnable runnable);

    /**
     * Supplies a CompletableFuture asynchronously using the platform's default executor
     * @param supplier the supplier
     * @param <T> type of object to return
     * @return a completablefuture containin the type
     */
    <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier);

}
