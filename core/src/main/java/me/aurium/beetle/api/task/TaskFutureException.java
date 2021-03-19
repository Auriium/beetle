package me.aurium.beetle.api.task;

public class TaskFutureException extends RuntimeException{

    public TaskFutureException(Throwable t) {
        super(t);
    }

}
