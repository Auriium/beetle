package me.aurium.beetle.file;

/**
 * IOException that is a runtime exception
 */
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
