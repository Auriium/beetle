package me.aurium.beetle.core.utility.exception;

/**
 * Specific marker exception
 */
public class IllegalCommandMapState extends RuntimeException {

    public IllegalCommandMapState(String message) {
        super(message);
    }

    public IllegalCommandMapState(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalCommandMapState(Throwable cause) {
        super(cause);
    }

}
