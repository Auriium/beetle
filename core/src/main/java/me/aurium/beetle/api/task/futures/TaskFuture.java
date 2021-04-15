package me.aurium.beetle.api.task.futures;

import me.aurium.beetle.api.task.ExecutorProvider;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.function.*;

/**
 * Represents a future that is typically backed by a common async executor (typically a tasker's) rather than from the common pool.
 *
 * Still allows access to specified executors rather than the integrated executor.
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class TaskFuture<T> extends CompletableFuture<T> {

    private final ExecutorProvider asyncExecutor;

    public TaskFuture(ExecutorProvider executorProvider) {
        this.asyncExecutor = executorProvider;
    }

    @Override
    public Executor defaultExecutor() {
        return asyncExecutor.getAsyncExecutor();
    }

    @Override
    public <U> CompletableFuture<U> newIncompleteFuture() {
        return new TaskFuture<>(asyncExecutor);
    }

    @Override
    public <U> TaskFuture<U> thenApply(Function<? super T, ? extends U> fn) {
        return (TaskFuture<U>) super.thenApply(fn);
    }

    @Override
    public <U> TaskFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn) {
        return (TaskFuture<U>) super.thenApplyAsync(fn);
    }

    @Override
    public <U> TaskFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn, Executor executor) {
        return (TaskFuture<U>) super.thenApplyAsync(fn,executor);
    }

    @Override
    public TaskFuture<Void> thenAccept(Consumer<? super T> action) {
        return (TaskFuture<Void>) super.thenAccept(action);
    }

    @Override
    public TaskFuture<Void> thenAcceptAsync(Consumer<? super T> action) {
        return (TaskFuture<Void>) super.thenAcceptAsync(action);
    }

    @Override
    public TaskFuture<Void> thenAcceptAsync(Consumer<? super T> action, Executor executor) {
        return (TaskFuture<Void>) super.thenAcceptAsync(action,executor);
    }

    @Override
    public TaskFuture<Void> thenRun(Runnable action) {
        return (TaskFuture<Void>) super.thenRun(action);
    }

    @Override
    public TaskFuture<Void> thenRunAsync(Runnable action) {
        return (TaskFuture<Void>) super.thenRunAsync(action);
    }

    @Override
    public TaskFuture<Void> thenRunAsync(Runnable action, Executor executor) {
        return (TaskFuture<Void>) super.thenRunAsync(action,executor);
    }

    @Override
    public <U, V> TaskFuture<V> thenCombine(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        return (TaskFuture<V>) super.thenCombine(other,fn);
    }

    @Override
    public <U, V> TaskFuture<V> thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        return (TaskFuture<V>) super.thenCombineAsync(other,fn);
    }

    @Override
    public <U, V> TaskFuture<V> thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn, Executor executor) {
        return (TaskFuture<V>) super.thenCombineAsync(other,fn,executor);
    }

    @Override
    public <U> TaskFuture<Void> thenAcceptBoth(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        return (TaskFuture<Void>) super.thenAcceptBoth(other,action);
    }

    @Override
    public <U> TaskFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        return (TaskFuture<Void>) super.thenAcceptBothAsync(other,action);
    }

    @Override
    public <U> TaskFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action, Executor executor) {
        return (TaskFuture<Void>) super.thenAcceptBothAsync(other,action,executor);
    }

    @Override
    public TaskFuture<Void> runAfterBoth(CompletionStage<?> other, Runnable action) {
        return (TaskFuture<Void>) super.runAfterBoth(other,action);
    }

    @Override
    public TaskFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action) {
        return (TaskFuture<Void>) super.runAfterBothAsync(other,action);
    }

    @Override
    public TaskFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return (TaskFuture<Void>) super.runAfterBothAsync(other,action,executor);
    }

    @Override
    public <U> TaskFuture<U> applyToEither(CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return (TaskFuture<U>) super.applyToEither(other,fn);
    }

    @Override
    public <U> TaskFuture<U> applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return (TaskFuture<U>) super.applyToEitherAsync(other,fn);
    }

    @Override
    public <U> TaskFuture<U> applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T, U> fn, Executor executor) {
        return (TaskFuture<U>) super.applyToEitherAsync(other,fn,executor);
    }

    @Override
    public TaskFuture<Void> acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action) {
        return (TaskFuture<Void>) super.acceptEither(other,action);
    }

    @Override
    public TaskFuture<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action) {
        return (TaskFuture<Void>) super.acceptEitherAsync(other,action);
    }

    @Override
    public TaskFuture<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action, Executor executor) {
        return (TaskFuture<Void>) super.acceptEitherAsync(other,action,executor);
    }

    @Override
    public TaskFuture<Void> runAfterEither(CompletionStage<?> other, Runnable action) {
        return (TaskFuture<Void>) super.runAfterEither(other,action);
    }

    @Override
    public TaskFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action) {
        return (TaskFuture<Void>) super.runAfterEitherAsync(other,action);
    }

    @Override
    public TaskFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return (TaskFuture<Void>) super.runAfterEitherAsync(other,action,executor);
    }

    @Override
    public <U> TaskFuture<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> fn) {
        return (TaskFuture<U>) super.thenCompose(fn);
    }

    @Override
    public <U> TaskFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn) {
        return (TaskFuture<U>) super.thenComposeAsync(fn);
    }

    @Override
    public <U> TaskFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn, Executor executor) {
        return (TaskFuture<U>) super.thenComposeAsync(fn,executor);
    }

    @Override
    public <U> TaskFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> fn) {
        return (TaskFuture<U>) super.handle(fn);
    }

    @Override
    public <U> TaskFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn) {
        return (TaskFuture<U>) super.handleAsync(fn);
    }

    @Override
    public <U> TaskFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn, Executor executor) {
        return (TaskFuture<U>) super.handleAsync(fn, executor);
    }

    @Override
    public TaskFuture<T> whenComplete(BiConsumer<? super T, ? super Throwable> action) {
        return (TaskFuture<T>) super.whenComplete(action);
    }

    @Override
    public TaskFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action) {
        return (TaskFuture<T>) super.whenCompleteAsync(action);
    }

    @Override
    public TaskFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action, Executor executor) {
        return (TaskFuture<T>) super.whenCompleteAsync(action,executor);
    }

    @Override
    public TaskFuture<T> completeAsync(Supplier<? extends T> supplier) {
        return (TaskFuture<T>) super.completeAsync(supplier);
    }

    @Override
    public TaskFuture<T> completeAsync(Supplier<? extends T> supplier, Executor executor) {
        return (TaskFuture<T>) super.completeAsync(supplier, executor);
    }

    @Override
    public TaskFuture<T> exceptionally(Function<Throwable, ? extends T> fn) {
        return (TaskFuture<T>) super.exceptionally(fn);
    }

    /**
     * This does exactly what you think it does. If you have a main thread, don't call this. (Although if you have a main thread,
     * you should be using {@link SyncTaskerFuture} instead.
     *
     * @param unit time unit
     * @param amount amount of time units to sleep for
     * @return itself
     */
    public TaskFuture<T> thenSleep(TimeUnit unit, long amount) {
        return this.thenApply(s -> {
            try {
                Thread.sleep(unit.toMillis(amount));
            } catch (InterruptedException e) {
                e.printStackTrace(); //TODO
            }

            return s;
        }); //is there a point to this or should i just return ""this""

        //i want to be able to
        //somefuture
        //.thenSleep(TimeUnit.MINUTES, 1)
        //.thenRun(() -> { //something })
        //.thenSleep(TimeUnits.MINUTES, 1)
        //.thenRunSync(() -> { //something})


    }

    public TaskFuture<T> thenWaitAsync(TimeUnit unit, long amount) {
        return this.thenApplyAsync((s) -> s ,CompletableFuture.delayedExecutor(amount,unit,defaultExecutor()));
    }

    public TaskFuture<T> thenWaitAsync(TimeUnit unit, long amount, Executor executor) {
        return this.thenApplyAsync((s) -> s ,CompletableFuture.delayedExecutor(amount,unit,executor));
    }

    @Override
    public TaskFuture<T> toCompletableFuture() {
        return this;
    }
}
