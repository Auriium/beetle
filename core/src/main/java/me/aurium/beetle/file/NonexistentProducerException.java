package me.aurium.beetle.file;

/**
 * Exception thrown when a producer is requested that does not exist in the fileprovider
 */
public class NonexistentProducerException extends RuntimeException{

    public NonexistentProducerException() {
        super("A producer with that name does not exist in the FileProvider!");
    }

}
