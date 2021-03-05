package me.aurium.beetle.task;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Represents something that can run tasks overlaid onto the core.
 */
public interface TaskRunner {

    /**
     * Runs a task synchronously based on the platform
     * @param runnable runnable to run
     */
    void runTaskSync(Runnable runnable);

    /**
     * Runs a task asynchronously based on the platform
     * @param runnable runnable to run
     */
    void runTaskAsync(Runnable runnable);

    /**
     * Supplies a CompletableFuture asynchronously
     * @param supplier the supplier
     * @param <T> type of object to return
     * @return a completablefuture containin the type
     */
    <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier);

}
