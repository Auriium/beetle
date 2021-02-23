package me.aurium.beetle.core.config;

import java.io.File;

/**
 * Interface for something that can produce a dataholder implementation from a file
 * @param <T> the dataholder to produce
 */
public interface FileProducer<T extends DataHolder> {

    T produce(File file);

}
