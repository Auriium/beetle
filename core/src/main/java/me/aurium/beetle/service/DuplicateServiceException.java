package me.aurium.beetle.service;

/**
 * Exception thrown when there is already a service registered to the ServiceRegistry
 */
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
