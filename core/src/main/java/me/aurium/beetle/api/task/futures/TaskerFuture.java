package me.aurium.beetle.api.task.futures;

import me.aurium.beetle.api.task.futures.completion.CompletionStack;
import me.aurium.beetle.api.task.futures.completion.value.CompletionObject;

import java.util.concurrent.*;

public class TaskerFuture<T> implements Future<T>{

    private final CompletionObject<T> object = new CompletionObject<>();
    private final CompletionStack<T> stack = new CompletionStack<>(object);

    private final FutureCore futureCore;

    public TaskerFuture(FutureCore futureCore) {
        this.futureCore = futureCore;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return object.access().isDone();
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }


}
