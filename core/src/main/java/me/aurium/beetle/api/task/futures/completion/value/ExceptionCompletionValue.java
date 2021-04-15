package me.aurium.beetle.api.task.futures.completion.value;

import me.aurium.beetle.api.task.futures.exception.ThrowableWrapper;

import java.util.Optional;

public class ExceptionCompletionValue<T> implements CompletionValue<T> {

    private final ThrowableWrapper wrapper;

    public ExceptionCompletionValue(ThrowableWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public Optional<T> getNow() {
        return Optional.empty();
    }

    @Override
    public Optional<ThrowableWrapper> getException() {
        return Optional.of(wrapper);
    }

    @Override
    public boolean isDone() {
        return true;
    }
}
