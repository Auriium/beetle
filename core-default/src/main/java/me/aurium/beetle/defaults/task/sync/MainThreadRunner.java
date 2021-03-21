package me.aurium.beetle.defaults.task.sync;

import me.aurium.beetle.api.task.sync.BlockingBehavior;
import me.aurium.beetle.api.task.sync.SyncFuture;
import me.aurium.beetle.api.task.sync.SyncQueue;
import me.aurium.beetle.api.task.sync.SyncTaskRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class MainThreadRunner implements SyncTaskRunner {

    private final BlockingBehavior behavior;
    private final SyncQueue queue;
    private final Executor asyncExecutor;
    private final Thread mainThread;

    private final static Logger logger = LoggerFactory.getLogger(MainThreadRunner.class);

    public MainThreadRunner(BlockingBehavior behavior, SyncQueue queue, Executor asyncExecutor, Thread mainThread) {
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
        //please check this over a248. I do believe it is correct but i just want to make sure.
        return (SyncFuture<T>) new SyncFuture<T>(mainThread,queue,behavior).completeAsync(supplier,asyncExecutor);
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
        return (SyncFuture<T>) new SyncFuture<T>(mainThread,queue,behavior).completeAsync(supplier,queue);
    }
}
