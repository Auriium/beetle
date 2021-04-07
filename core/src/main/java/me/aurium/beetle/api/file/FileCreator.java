package me.aurium.beetle.api.file;

import me.aurium.beetle.api.file.producer.CreationOptions;
import me.aurium.beetle.api.file.producer.FileProvisioner;

/**
 * Represents something that makes files from a centralized source
 */
public interface FileCreator {

    <T extends FileProvisioner<?,?>> T createAndLoad(CreationOptions<T> options);
    <T extends FileProvisioner<E,?>,E> E createAndAccess(CreationOptions<T> options);

}
