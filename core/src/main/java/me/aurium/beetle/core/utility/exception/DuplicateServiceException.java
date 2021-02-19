package me.aurium.beetle.core.utility.exception;

public class DuplicateServiceException extends RuntimeException {

    public DuplicateServiceException(String message) {
        super(message);
    }

    public DuplicateServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateServiceException(Throwable cause) {
        super(cause);
    }

}
