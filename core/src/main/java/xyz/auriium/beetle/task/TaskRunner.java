package xyz.auriium.beetle.task;

import xyz.auriium.beetle.task.futures.TaskFuture;

import java.util.function.Supplier;

/**
 * Acts as both a centralized runnable runner and taskfuture provider
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
    <T> TaskFuture<T> supplyAsync(Supplier<T> supplier);

}
