package me.aurium.beetle.defaults.task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class GenericTasker extends AbstractTasker{

    public GenericTasker(ExecutorService service) {
        super(service);
    }

    @Override
    public void launch() {
        CompletableFuture.delayedExecutor(50L, TimeUnit.MICROSECONDS).execute(asQueue()::tick);
    }
}
