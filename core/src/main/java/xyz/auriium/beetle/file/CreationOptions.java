package xyz.auriium.beetle.file;

import java.nio.file.Path;

/**
 * Represents options that can create a producer in a Creator
 */
public interface CreationOptions<T extends FileProvisioner<?,?>> {

    T newProducer(Path basePath);

}
