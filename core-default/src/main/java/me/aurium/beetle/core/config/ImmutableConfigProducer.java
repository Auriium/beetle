package me.aurium.beetle.core.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ImmutableConfigProducer<T extends ImmutableConfig> implements FileProducer<T> {

    private final Class<T> clz;

    public ImmutableConfigProducer(Class<T> clz) {
        this.clz = clz;
    }

    @Override
    public T produce(Path path) throws IOException {
        return null;
    }
}
