package me.aurium.beetle.defaults.task.sync;

import me.aurium.beetle.api.task.sync.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class MainThreadRunner implements SyncTaskRunner {

    private final TaskCoordinator behavior;
    private final SyncQueue queue;
    private final Executor asyncExecutor;
    private final Thread mainThread;

    private final static Logger logger = LoggerFactory.getLogger(MainThreadRunner.class);

    public MainThreadRunner(TaskCoordinator behavior, SyncQueue queue, Executor asyncExecutor, Thread mainThread) {
        this.behavior = behavior;
        this.queue = queue;
        this.asyncExecutor = asyncExecutor;
        this.mainThread = mainThread;
    }

    @Override
    public void executeAsync(Runnable runnable) {
        supplyAsync(() -> {
           runnable.run();

           return null;
        }).whenComplete((ignored,throwabled) -> {
            if (throwabled != null) {
                logger.error("async execution failed",throwabled);
            }
        });
    }

    @Override
    public <T> SyncFuture<T> supplyAsync(Supplier<T> supplier) {
        return (SyncFuture<T>) new SyncFuture<T>(behavior).completeAsync(supplier,asyncExecutor);
    }

    @Override
    public void executeSync(Runnable runnable) {
        supplySync(() -> {
            runnable.run();

            return null;
        }).whenComplete((ignored,throwabled) -> {
            if (throwabled != null) {
                logger.error("sync execution failed",throwabled);
            }
        });
    }

    @Override
    public <T> SyncFuture<T> supplySync(Supplier<T> supplier) { //TODO let syncfuture, or it's parent taskfuture,
        //TODO implement CompletionStage and override completeAsync so we can have a type guarantee
        return (SyncFuture<T>) new SyncFuture<T>(behavior).completeAsync(supplier,queue);
    }
}
