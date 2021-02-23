package me.aurium.beetle.core.config;

import java.io.File;
import java.nio.file.Path;

public abstract class SimpleFileProvider implements FileProvider{

    @Override
    public <T extends DataHolder> T getDataHolderFile(FileProducer<T> producer, File file) {
        return producer.produce(file);
    }

    @Override
    public <T extends DataHolder> T getDataHolderAbsolute(FileProducer<T> producer, Path path) {
        return producer.produce(path.toFile());
    }

    @Override
    public <T extends DataHolder> T getDataHolderAbsolute(FileProducer<T> producer, String string) {
        return producer.produce(Path.of(string).toFile());
    }
}
