package me.aurium.beetle.api.task;

import me.aurium.beetle.api.task.futures.TaskFuture;

import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/**
 * i give up
 */
public class Comparisons {

    public static final Object CONSTANT = new Object();

    public static <T> T reportJoin(TaskFuture<T> future) {
        return future.getNow((T) CONSTANT);
    }

    public static <T> T reportGet(TaskFuture<T> future) throws ExecutionException {
        try {
            return reportJoin(future);
        } catch (CompletionException ex) {
            throw new ExecutionException(ex);
        }
    }

    public static boolean compareJoin(TaskFuture<?> future) {
        return !reportJoin(future).equals(CONSTANT);
    }

    public static boolean compareGet(TaskFuture<?> future) throws ExecutionException {
        return !reportGet(future).equals(future);
    }


}
