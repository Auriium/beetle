package me.aurium.beetle.api.file.producer;

import java.nio.file.Path;

/**
 * Represents options that can create a producer in a Creator
 */
public interface CreationOptions<T extends FileProducer<?,?>> {

    T newProducer(Path basePath);

}
