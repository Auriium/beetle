package me.aurium.beetle.core.config;

import java.io.IOException;
import java.nio.file.Path;

public class CommonFileProvider implements FileProvider {

    private final Path local;

    public CommonFileProvider(Path path) {
        this.local = path;
    }

    @Override
    public <T extends DataHolder> T getDataHolder(FileProducer<T> producer, Path path) {
        try {
            return producer.produce(local.resolve(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public <T extends DataHolder> T getDataHolder(FileProducer<T> producer, String string) {
        try {
            return producer.produce(local.resolve(Path.of(string)));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public <T extends DataHolder> T getDataHolderAbsolute(FileProducer<T> producer, Path path) {
        try {
            return producer.produce(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public <T extends DataHolder> T getDataHolderAbsolute(FileProducer<T> producer, String string) {
        try {
            return producer.produce(Path.of(string));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
