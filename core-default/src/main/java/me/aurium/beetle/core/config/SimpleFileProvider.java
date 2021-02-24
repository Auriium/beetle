package me.aurium.beetle.core.config;

import me.aurium.beetle.core.utility.exception.UncheckedIOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public abstract class SimpleFileProvider implements FileProvider{

    @Override
    public <T extends DataHolder> T getDataHolderFile(FileProducer<T> producer, File file) {
        try {
            return producer.produce(file);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    @Override
    public <T extends DataHolder> T getDataHolderAbsolute(FileProducer<T> producer, Path path) {
        try {
            return producer.produce(path.toFile());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    @Override
    public <T extends DataHolder> T getDataHolderAbsolute(FileProducer<T> producer, String string) {
        try {
            return producer.produce(Path.of(string).toFile());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
