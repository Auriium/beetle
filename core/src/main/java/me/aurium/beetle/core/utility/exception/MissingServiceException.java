package me.aurium.beetle.core.utility.exception;

public class MissingServiceException extends RuntimeException {

    public MissingServiceException(String message) {
        super(message);
    }

    public MissingServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingServiceException(Throwable cause) {
        super(cause);
    }

}
