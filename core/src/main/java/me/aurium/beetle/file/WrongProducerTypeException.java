package me.aurium.beetle.file;

/**
 * Insanely verbose exception name
 *
 * Exception thrown when a key requests a producer already registered of a different type
 */
public class WrongProducerTypeException extends RuntimeException{

    public WrongProducerTypeException(Class<?> expectedType) {
        super("Dataproducer was not of expected type " + expectedType + " in the ProducerMap");
    }

}
