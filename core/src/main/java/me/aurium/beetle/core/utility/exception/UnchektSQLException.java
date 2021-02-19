package me.aurium.beetle.core.utility.exception;

/**
 * SQLException, but unchecked.
 *
 * I didn't steal this from anywhere I promise
 */
public class UnchektSQLException extends RuntimeException {

    public UnchektSQLException(String message) {
        super(message);
    }

    public UnchektSQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnchektSQLException(Throwable cause) {
        super(cause);
    }

}
