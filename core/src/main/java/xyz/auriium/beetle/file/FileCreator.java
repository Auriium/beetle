package xyz.auriium.beetle.file;

/**
 * Represents something that makes files from a centralized source
 */
public interface FileCreator {

    <T extends FileProvisioner<?,?>> T createAndLoad(CreationOptions<T> options);
    <T extends FileProvisioner<E,?>,E> E createAndAccess(CreationOptions<T> options);

}
