package me.aurium.beetle.file.configuration;

/**
 * Exception thrown when a configuration is loaded incorrectly
 */
public class IllegalConfigException extends RuntimeException {

    IllegalConfigException(String throwable) {
        super(throwable);
    }



}
