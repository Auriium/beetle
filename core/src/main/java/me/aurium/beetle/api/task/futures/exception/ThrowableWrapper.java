package me.aurium.beetle.api.task.futures.exception;

public class ThrowableWrapper {

    private final Throwable throwable;
    private final boolean thrown;

    public ThrowableWrapper(Throwable throwable, boolean thrown) {
        this.throwable = throwable;
        this.thrown = thrown;
    }
}
