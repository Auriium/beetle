package me.aurium.beetle.api.task.futures.completion.value;

import me.aurium.beetle.api.task.futures.exception.ThrowableWrapper;

public class CompletionObject<T> {

    private volatile CompletionValue<T> value = new IncompleteCompletionValue<>();

    public void complete(T object) {
        this.value = new ObjectCompletionValue<>(object);
    }

    public void completeExceptionally(ThrowableWrapper throwable) {
        this.value = new ExceptionCompletionValue<>(throwable);
    }

    public CompletionValue<T> access() {
        return value;
    }

}
