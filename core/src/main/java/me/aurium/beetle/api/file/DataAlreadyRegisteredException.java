package me.aurium.beetle.api.file;

/**
 * Exception thrown when a producer is already registered
 */
public class DataAlreadyRegisteredException extends RuntimeException{

    public DataAlreadyRegisteredException(String identifier) {
        super("The dataproducer with identifier " + identifier + " is already registered!");
    }

}
