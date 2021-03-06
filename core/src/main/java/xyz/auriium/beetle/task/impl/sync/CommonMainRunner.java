package xyz.auriium.beetle.task.impl.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.auriium.beetle.task.futures.SyncTaskerFuture;
import xyz.auriium.beetle.task.sync.SyncExecutorProvider;
import xyz.auriium.beetle.task.sync.SyncTaskRunner;
import xyz.auriium.beetle.task.sync.coordination.TaskCoordinator;

import java.util.function.Supplier;

public class CommonMainRunner implements SyncTaskRunner {

    private final SyncExecutorProvider provider;
    private final TaskCoordinator coordinator;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public CommonMainRunner(SyncExecutorProvider provider, TaskCoordinator coordinator) {
        this.provider = provider;
        this.coordinator = coordinator;
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
    public <T> SyncTaskerFuture<T> supplyAsync(Supplier<T> supplier) {
        return new SyncTaskerFuture<T>(provider,coordinator).completeAsync(supplier);
    }

    @Override
    public void executeSync(Runnable runnable) {
        supplySync(() -> {
            runnable.run();

            return null;
        }).whenComplete((ignored,throwable) -> {
            if (throwable != null) {
                logger.error("Exception while executing sync", throwable);
            }
        });
    }

    @Override
    public <T> SyncTaskerFuture<T> supplySync(Supplier<T> supplier) {
        return new SyncTaskerFuture<T>(provider,coordinator).completeSync(supplier);
    }
}
