package me.aurium.beetle.datacore;

/**
 * SQLException, but unchecked.
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
