package me.aurium.beetle.api.task.futures.completion.value;

import me.aurium.beetle.api.task.futures.exception.ThrowableWrapper;

import java.util.Optional;

public class ObjectCompletionValue<T> implements CompletionValue<T> {

    private final T value;

    public ObjectCompletionValue(T value) {
        this.value = value;
    }

    @Override
    public Optional<T> getNow() {
        return Optional.of(value);
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
