package me.aurium.beetle.api.task.futures.completion.value;

import me.aurium.beetle.api.task.futures.exception.ThrowableWrapper;

import java.util.Optional;

public interface CompletionValue<T> {

    Optional<T> getNow();
    Optional<ThrowableWrapper> getException();

    boolean isDone();

    static <C> CompletionValue<C> of(C type) {
        return new ObjectCompletionValue<>(type);
    }

    static <C> CompletionValue<C> ofExceptionally(ThrowableWrapper wrapper) {
        return new ExceptionCompletionValue<>(wrapper);
    }

}
