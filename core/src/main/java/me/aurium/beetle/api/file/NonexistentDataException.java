package me.aurium.beetle.api.file;

/**
 * Exception thrown when a producer is requested that does not exist in the fileprovider
 */
public class NonexistentDataException extends RuntimeException{

    public NonexistentDataException() {
        super("A producer with that name does not exist in the FileProvider!");
    }

}
