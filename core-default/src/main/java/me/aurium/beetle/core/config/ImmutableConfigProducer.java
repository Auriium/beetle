package me.aurium.beetle.core.config;

import java.io.File;

public class ImmutableConfigProducer<T extends ImmutableConfig> implements FileProducer<T> {

    private final Class<T> clz;

    public ImmutableConfigProducer(Class<T> clz) {
        this.clz = clz;
    }

    @Override
    public T produce(File file) {

        //do reading
        //Reader.read(clz.get(file));

        return null;
    }
}
