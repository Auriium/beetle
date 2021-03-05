package me.aurium.beetle.command;

/**
 * Exception thrown when an internal command map already contains a command
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
