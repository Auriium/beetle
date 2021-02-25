package me.aurium.beetle.core.config;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Interface for something that can produce a dataholder implementation from a file
 * @param <T> the dataholder to produce
 */
public interface FileProducer<T extends DataHolder> {

    T produce(Path path) throws IOException;

}
