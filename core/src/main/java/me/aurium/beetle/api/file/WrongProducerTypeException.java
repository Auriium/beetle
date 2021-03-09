package me.aurium.beetle.api.file;

/**
 * Insanely verbose exception name
 *
 * Exception thrown when a key requests a producer already registered of a different type
 */
public class WrongProducerTypeException extends RuntimeException{

    public WrongProducerTypeException() {
        super("Dataproducer was not of expected type in the ProducerMap");
    }

}
