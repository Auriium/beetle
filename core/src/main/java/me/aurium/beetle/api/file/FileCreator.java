package me.aurium.beetle.api.file;

import me.aurium.beetle.api.file.producer.*;

/**
 * Represents something that makes files from a centralized source
 */
public interface FileCreator {

    <T extends FileProvisioner<?,?>> T create(CreationOptions<T> options);

}
