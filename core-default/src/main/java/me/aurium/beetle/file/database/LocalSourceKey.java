package me.aurium.beetle.file.database;

import me.aurium.beetle.file.extension.LocalDataExtension;
import me.aurium.beetle.file.producer.Producer;
import me.aurium.beetle.file.producer.ProducerKey;

import java.nio.file.Path;

public class LocalSourceKey implements ProducerKey<LocalSource,LocalSourceOptions> {
    @Override
    public LocalSource newProducer(LocalSourceOptions options, Path path) {
        LocalDataExtension extension = options.getExtension();
        Path combined = path.resolve(extension.of(options.getPath()));

        return new LocalSource(combined,extension.getType(), options.getUsername(), options.getPassword());
    }

    @Override
    public String getIdentifier() {
        return null;
    }

    @Override
    public boolean isInstance(Producer producer) {
        return false;
    }
}
