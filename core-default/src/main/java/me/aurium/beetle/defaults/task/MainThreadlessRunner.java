package me.aurium.beetle.defaults.task;

import me.aurium.beetle.api.task.TaskRunner;
import me.aurium.beetle.api.util.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class MainThreadlessRunner implements TaskRunner {

    private final Executor asyncExecutor;

    private final Logger logger = LoggerFactory.getLogger(MainThreadlessRunner.class);

    public MainThreadlessRunner(Executor asyncExecutor) {
        this.asyncExecutor = asyncExecutor;
    }

    @Override
    public void executeSync(Runnable runnable) {
        throw new NotImplementedException("no main thread");
    }

    @Override
    public void executeAsync(Runnable runnable) {
        supplyAsync(() -> {
            runnable.run();

            return null;
        }).whenComplete((ignored,exception) -> {
            if (exception != null) {
                logger.error(exception.getLocalizedMessage());
            }
        });
    }

    @Override
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        throw new NotImplementedException("no main thread");
    }

    @Override
    public <T> CompletableFuture<T> supplySync(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier,asyncExecutor);
    }
}
