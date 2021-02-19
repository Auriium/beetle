package me.aurium.beetle.core.runner;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Represents something that can run tasks overlaid onto the core.
 */
public interface TaskRunner {

    void runTaskSync(Runnable runnable);
    void runTaskAsync(Runnable runnable);

    <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier);

}
