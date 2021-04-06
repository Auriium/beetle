package me.aurium.beetle.api.task.futures;

import me.aurium.beetle.api.task.Comparisons;
import me.aurium.beetle.api.task.sync.SyncExecutorProvider;
import me.aurium.beetle.api.task.sync.coordination.TaskCoordinator;

import java.util.concurrent.*;
import java.util.function.*;

@SuppressWarnings("unchecked")
public class SyncTaskerFuture<T> extends TaskFuture<T> {

    private final SyncExecutorProvider provider;
    private final Executor syncExecutor;
    private final TaskCoordinator coordinator;

    public SyncTaskerFuture(SyncExecutorProvider provider, TaskCoordinator coordinator) {
        super(provider);

        this.provider = provider;
        this.syncExecutor = provider.getSyncExecutor();
        this.coordinator = coordinator;
    }

    @Override
    public <U> CompletableFuture<U> newIncompleteFuture() {
        return new SyncTaskerFuture<>(provider,coordinator);
    }

    public SyncTaskerFuture<T> completeSync(Supplier<? extends T> supplier) {
        return (SyncTaskerFuture<T>) super.completeAsync(supplier,syncExecutor);
    }

    public <U> SyncTaskerFuture<U> thenApplySync(Function<? super T, ? extends U> fn) {
        return (SyncTaskerFuture<U>) super.thenApplyAsync(fn,syncExecutor);
    }

    public SyncTaskerFuture<Void> thenAcceptSync(Consumer<? super T> action) {
        return (SyncTaskerFuture<Void>) super.thenAcceptAsync(action,syncExecutor)  ;
    }

    public SyncTaskerFuture<Void> thenRunSync(Runnable action) {
        return (SyncTaskerFuture<Void>) super.thenRunAsync(action,syncExecutor);
    }

    public <U, V> SyncTaskerFuture<V> thenCombineSync(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        return (SyncTaskerFuture<V>) super.thenCombineAsync(other,fn,syncExecutor);
    }

    public <U> SyncTaskerFuture<Void> thenAcceptBothSync(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        return (SyncTaskerFuture<Void>) super.thenAcceptBothAsync(other,action,syncExecutor);
    }

    public SyncTaskerFuture<Void> runAfterBothSync(CompletionStage<?> other, Runnable action) {
        return (SyncTaskerFuture<Void>) super.runAfterBothAsync(other,action,syncExecutor);
    }

    public <U> SyncTaskerFuture<U> applyToEitherSync(CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return (SyncTaskerFuture<U>) super.applyToEitherAsync(other,fn,syncExecutor);
    }

    public SyncTaskerFuture<Void> acceptEitherSync(CompletionStage<? extends T> other, Consumer<? super T> action) {
        return (SyncTaskerFuture<Void>) super.acceptEitherAsync(other,action,syncExecutor);
    }

    public SyncTaskerFuture<Void> runAfterEitherSync(CompletionStage<?> other, Runnable action) {
        return (SyncTaskerFuture<Void>) super.runAfterEitherAsync(other,action,syncExecutor);
    }

    public <U> SyncTaskerFuture<U> thenComposeSync(Function<? super T, ? extends CompletionStage<U>> fn) {
        return (SyncTaskerFuture<U>) super.thenComposeAsync(fn,syncExecutor);
    }

    public <U> SyncTaskerFuture<U> handleSync(BiFunction<? super T, Throwable, ? extends U> fn) {
        return (SyncTaskerFuture<U>) super.handleAsync(fn,syncExecutor);
    }

    public SyncTaskerFuture<T> whenCompleteSync(BiConsumer<? super T, ? super Throwable> action) {
        return (SyncTaskerFuture<T>) super.whenCompleteAsync(action,syncExecutor);
    }


    //SHIT

    @Override
    public <U> SyncTaskerFuture<U> thenApply(Function<? super T, ? extends U> fn) {
        return (SyncTaskerFuture<U>) super.thenApply(fn);
    }

    @Override
    public <U> SyncTaskerFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn) {
        return (SyncTaskerFuture<U>) super.thenApplyAsync(fn);
    }

    @Override
    public <U> SyncTaskerFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn, Executor executor) {
        return (SyncTaskerFuture<U>) super.thenApplyAsync(fn,executor);
    }

    @Override
    public SyncTaskerFuture<Void> thenAccept(Consumer<? super T> action) {
        return (SyncTaskerFuture<Void>) super.thenAccept(action);
    }

    @Override
    public SyncTaskerFuture<Void> thenAcceptAsync(Consumer<? super T> action) {
        return (SyncTaskerFuture<Void>) super.thenAcceptAsync(action);
    }

    @Override
    public SyncTaskerFuture<Void> thenAcceptAsync(Consumer<? super T> action, Executor executor) {
        return (SyncTaskerFuture<Void>) super.thenAcceptAsync(action,executor);
    }

    @Override
    public SyncTaskerFuture<Void> thenRun(Runnable action) {
        return (SyncTaskerFuture<Void>) super.thenRun(action);
    }

    @Override
    public SyncTaskerFuture<Void> thenRunAsync(Runnable action) {
        return (SyncTaskerFuture<Void>) super.thenRunAsync(action);
    }

    @Override
    public SyncTaskerFuture<Void> thenRunAsync(Runnable action, Executor executor) {
        return (SyncTaskerFuture<Void>) super.thenRunAsync(action,executor);
    }

    @Override
    public <U, V> SyncTaskerFuture<V> thenCombine(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        return (SyncTaskerFuture<V>) super.thenCombine(other,fn);
    }

    @Override
    public <U, V> SyncTaskerFuture<V> thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        return (SyncTaskerFuture<V>) super.thenCombineAsync(other,fn);
    }

    @Override
    public <U, V> SyncTaskerFuture<V> thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn, Executor executor) {
        return (SyncTaskerFuture<V>) super.thenCombineAsync(other,fn,executor);
    }

    @Override
    public <U> SyncTaskerFuture<Void> thenAcceptBoth(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        return (SyncTaskerFuture<Void>) super.thenAcceptBoth(other,action);
    }

    @Override
    public <U> SyncTaskerFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        return (SyncTaskerFuture<Void>) super.thenAcceptBothAsync(other,action);
    }

    @Override
    public <U> SyncTaskerFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action, Executor executor) {
        return (SyncTaskerFuture<Void>) super.thenAcceptBothAsync(other,action,executor);
    }

    @Override
    public SyncTaskerFuture<Void> runAfterBoth(CompletionStage<?> other, Runnable action) {
        return (SyncTaskerFuture<Void>) super.runAfterBoth(other,action);
    }

    @Override
    public SyncTaskerFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action) {
        return (SyncTaskerFuture<Void>) super.runAfterBothAsync(other,action);
    }

    @Override
    public SyncTaskerFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return (SyncTaskerFuture<Void>) super.runAfterBothAsync(other,action,executor);
    }

    @Override
    public <U> SyncTaskerFuture<U> applyToEither(CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return (SyncTaskerFuture<U>) super.applyToEither(other,fn);
    }

    @Override
    public <U> SyncTaskerFuture<U> applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return (SyncTaskerFuture<U>) super.applyToEitherAsync(other,fn);
    }

    @Override
    public <U> SyncTaskerFuture<U> applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T, U> fn, Executor executor) {
        return (SyncTaskerFuture<U>) super.applyToEitherAsync(other,fn,executor);
    }

    @Override
    public SyncTaskerFuture<Void> acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action) {
        return (SyncTaskerFuture<Void>) super.acceptEither(other,action);
    }

    @Override
    public SyncTaskerFuture<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action) {
        return (SyncTaskerFuture<Void>) super.acceptEitherAsync(other,action);
    }

    @Override
    public SyncTaskerFuture<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action, Executor executor) {
        return (SyncTaskerFuture<Void>) super.acceptEitherAsync(other,action,executor);
    }

    @Override
    public SyncTaskerFuture<Void> runAfterEither(CompletionStage<?> other, Runnable action) {
        return (SyncTaskerFuture<Void>) super.runAfterEither(other,action);
    }

    @Override
    public SyncTaskerFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action) {
        return (SyncTaskerFuture<Void>) super.runAfterEitherAsync(other,action);
    }

    @Override
    public SyncTaskerFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return (SyncTaskerFuture<Void>) super.runAfterEitherAsync(other,action,executor);
    }

    @Override
    public <U> SyncTaskerFuture<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> fn) {
        return (SyncTaskerFuture<U>) super.thenCompose(fn);
    }

    @Override
    public <U> SyncTaskerFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn) {
        return (SyncTaskerFuture<U>) super.thenComposeAsync(fn);
    }

    @Override
    public <U> SyncTaskerFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn, Executor executor) {
        return (SyncTaskerFuture<U>) super.thenComposeAsync(fn,executor);
    }

    @Override
    public <U> SyncTaskerFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> fn) {
        return (SyncTaskerFuture<U>) super.handle(fn);
    }

    @Override
    public <U> SyncTaskerFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn) {
        return (SyncTaskerFuture<U>) super.handleAsync(fn);
    }

    @Override
    public <U> SyncTaskerFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn, Executor executor) {
        return (SyncTaskerFuture<U>) super.handleAsync(fn, executor);
    }

    @Override
    public SyncTaskerFuture<T> whenComplete(BiConsumer<? super T, ? super Throwable> action) {
        return (SyncTaskerFuture<T>) super.whenComplete(action);
    }

    @Override
    public SyncTaskerFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action) {
        return (SyncTaskerFuture<T>) super.whenCompleteAsync(action);
    }

    @Override
    public SyncTaskerFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action, Executor executor) {
        return (SyncTaskerFuture<T>) super.whenCompleteAsync(action,executor);
    }

    @Override
    public SyncTaskerFuture<T> completeAsync(Supplier<? extends T> supplier) {
        return (SyncTaskerFuture<T>) super.completeAsync(supplier);
    }

    @Override
    public SyncTaskerFuture<T> completeAsync(Supplier<? extends T> supplier, Executor executor) {
        return (SyncTaskerFuture<T>) super.completeAsync(supplier, executor);
    }

    @Override
    public SyncTaskerFuture<T> exceptionally(Function<Throwable, ? extends T> fn) {
        return (SyncTaskerFuture<T>) super.exceptionally(fn);
    }

    @Override
    public TaskFuture<T> toCompletableFuture() {
        return this;
    }

    //SHIT STARTS HERE


    @Override
    public T get(long amount, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        if (coordinator.isMainThread()) {

            T returned;
            if (!(returned = Comparisons.reportGet(this)).equals(Comparisons.CONSTANT)) {
                return returned;
            }

            return coordinator.waitForTimer(this,unit,amount);
        }

        return super.get(amount,unit);
    }

    @Override
    public T get() throws ExecutionException, InterruptedException {
        if (coordinator.isMainThread()) {

            T returned;
            if (!(returned = Comparisons.reportGet(this)).equals(Comparisons.CONSTANT)) {
                return returned;
            }

            return coordinator.waitForGet(this);
        }

        return super.get();
    }

    @Override
    public T join() {

        if (coordinator.isMainThread()) {

            T returned;
            if (!(returned = Comparisons.reportJoin(this)).equals(Comparisons.CONSTANT)) {
                return returned;
            }

            return coordinator.waitForJoin(this);
        }

        return super.join();
    }

}
