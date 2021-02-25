package me.aurium.beetle.core.datacore;

/**
 * SQLException, but unchecked.
 *
 * I didn't steal this from anywhere I promise
 */
public class UncheckedSQLException extends RuntimeException {

    public UncheckedSQLException(String message) {
        super(message);
    }

    public UncheckedSQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncheckedSQLException(Throwable cause) {
        super(cause);
    }

}
