package me.aurium.beetle.api.file;

/**
 * Exception thrown when a producer is already registered
 */
public class ProducerAlreadyRegisteredException extends RuntimeException{

    public ProducerAlreadyRegisteredException(String identifier) {
        super("The dataproducer with identifier " + identifier + " is already registered!");
    }

}
