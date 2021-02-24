package me.aurium.beetle.core.utility.exception;

public class UncheckedIOException extends RuntimeException {

    public UncheckedIOException(String message) {
        super(message);
    }

    public UncheckedIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncheckedIOException(Throwable cause) {
        super(cause);
    }

}
