package me.aurium.beetle.defaults.task.syncless;

import me.aurium.beetle.api.task.ExecutorProvider;
import me.aurium.beetle.api.task.TaskRunner;
import me.aurium.beetle.api.task.futures.TaskFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class SynclessTaskRunner implements TaskRunner {

    private final ExecutorProvider executorProvider;

    //TODO remove dependency on logger
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public SynclessTaskRunner(ExecutorProvider executorProvider) {
        this.executorProvider = executorProvider;
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
    public <T> TaskFuture<T> supplyAsync(Supplier<T> supplier) {
        return new TaskFuture<T>(executorProvider).completeAsync(supplier);
    }
}
