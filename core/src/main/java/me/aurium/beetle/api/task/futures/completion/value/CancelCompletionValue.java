package me.aurium.beetle.api.task.futures.completion.value;

import me.aurium.beetle.api.task.futures.exception.ThrowableWrapper;

import java.util.Optional;

public class CancelCompletionValue<T> implements CompletionValue<T> {

    @Override
    public Optional<T> getNow() {
        return Optional.empty();
    }

    @Override
    public Optional<ThrowableWrapper> getException() {
        return Optional.empty();
    }

    @Override
    public boolean isDone() {
        return true;
    }
}
