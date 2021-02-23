package me.aurium.beetle.core.exception;

/**
 * Exception thrown when a file is not able to be loaded correctly
 */
public class IllegalFileException extends RuntimeException{

    public IllegalFileException(String throwable) {
        super(throwable);
    }

}
