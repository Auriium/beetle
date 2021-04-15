package me.aurium.beetle.api.task.futures.completion;

import me.aurium.beetle.api.task.futures.completion.value.CompletionObject;
import me.aurium.beetle.api.task.futures.completion.value.CompletionValue;

import java.util.concurrent.atomic.AtomicReference;

public class CompletionStack<T> {

    private final AtomicReference<Completion<T>> stack;
    private final CompletionObject<T> value;

    public CompletionStack(CompletionObject<T> value) {
        this.value = value;
        this.stack = new AtomicReference<>();
    }

    private void addAction(Completion<T> action) {
        Completion<T> previousAction;

        do {
            previousAction = stack.get();

            if (previousAction == null) {
                // The future is already complete
                action.handleCompletedValue(value);
                return;
            }
            action.setNext(previousAction);;
        } while (!stack.compareAndSet(previousAction, action));
    }

    private void completeFuture() {


        Completion<T> previousAction;
        do {
            previousAction = stack.get();
            if (previousAction == null) {
                return; //already complete
            }
        } while (!stack.compareAndSet(null, previousAction));

        // Run all the dependent actions
        for (Completion<T> action = previousAction; action != null; action = action.readNext()) {
            action.handleCompletedValue(value);
        }
    }
}
