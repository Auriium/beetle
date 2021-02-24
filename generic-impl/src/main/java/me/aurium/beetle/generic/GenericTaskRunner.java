package me.aurium.beetle.generic;

import me.aurium.beetle.core.runner.TaskRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class GenericTaskRunner implements TaskRunner {

    private final Executor executor;

    public GenericTaskRunner(Executor executor) {
        this.executor = executor;
    }

    public GenericTaskRunner() {
        this.executor = new CompletableFuture<>().defaultExecutor();
    }

    @Override
    public void runTaskSync(Runnable runnable) {
        executor.execute(runnable);
    }

    @Override
    public void runTaskAsync(Runnable runnable) {
        supplyAsync(() -> {
            runnable.run();

            return null;
        });
    }

    @Override
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier, executor);
    }
}
