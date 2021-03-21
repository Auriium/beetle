package me.aurium.beetle.defaults.task.syncless;

import me.aurium.beetle.api.task.ExecutorProvider;
import me.aurium.beetle.api.task.TaskRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class SynclessTaskRunner implements TaskRunner {

    private final ExecutorProvider executors;

    private static final Logger logger = LoggerFactory.getLogger(SynclessTaskRunner.class);

    public SynclessTaskRunner(ExecutorProvider executors) {
        this.executors = executors;
    }

    @Override
    public void executeAsync(Runnable runnable) {
        supplyAsync(() -> {
            runnable.run();

            return null;
        }).whenComplete((ignored,throwable) -> {
           if (throwable != null) {
               logger.error("Exception while executing async!",throwable);
           }
        });
    }

    @Override
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier,executors.getAsyncExecutor());
    }
}
