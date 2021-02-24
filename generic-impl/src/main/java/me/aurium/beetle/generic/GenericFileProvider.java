package me.aurium.beetle.generic;

import me.aurium.beetle.core.config.DataHolder;
import me.aurium.beetle.core.config.FileProducer;
import me.aurium.beetle.core.config.SimpleFileProvider;
import me.aurium.beetle.core.utility.exception.UncheckedIOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class GenericFileProvider extends SimpleFileProvider {

    private final File base;

    GenericFileProvider(File base) {
        this.base = base;
    }


    @Override
    public <T extends DataHolder> T getDataHolder(FileProducer<T> producer, Path path) {
        try {
            return producer.produce(base.toPath().resolve(path).toFile());
        } catch(IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    @Override
    public <T extends DataHolder> T getDataHolder(FileProducer<T> producer, String string) {
        try {
            return producer.produce(base.toPath().resolve(string).toFile());
        } catch(IOException e) {
            throw new UncheckedIOException(e);
        }

    }
}
