package me.aurium.beetle.core.exception;

/**
 * Exception thrown when a configuration is loaded incorrectly
 */
public class IllegalConfigException extends RuntimeException {

    IllegalConfigException(String throwable) {
        super(throwable);
    }



}
