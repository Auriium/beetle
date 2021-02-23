package me.aurium.beetle.core.omni;

import me.aurium.beetle.core.runner.TaskRunner;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Class that wraps Omnibus / FasterFutures allowing for superior future interaction.
 */
public class OmniTaskRunner implements TaskRunner {

    public OmniTaskRunner() {

    }

    @Override
    public void runTaskSync(Runnable runnable) {

    }

    @Override
    public void runTaskAsync(Runnable runnable) {

    }

    @Override
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        return null;
    }
}
