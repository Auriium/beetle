package me.aurium.beetle.api.task.futures.completion;

import me.aurium.beetle.api.task.futures.completion.value.CompletionObject;

public abstract class Completion<T> {

    private Completion<T> nextCompletion;

    public Completion<T> readNext() {
        return nextCompletion;
    }

    public void setNext(Completion<T> completion) {
        nextCompletion = completion;
    }

    abstract void handleCompletedValue(CompletionObject<T> value);

}
