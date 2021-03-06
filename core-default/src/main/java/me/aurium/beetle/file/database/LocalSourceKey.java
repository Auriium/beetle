package me.aurium.beetle.file.database;

import me.aurium.beetle.file.producer.Producer;
import me.aurium.beetle.file.producer.ProducerKey;

import java.nio.file.Path;

public class LocalSourceKey implements ProducerKey<LocalSource,LocalSourceOptions> {

    private final String identifier;

    public LocalSourceKey(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public LocalSource newProducer(LocalSourceOptions options, Path path) {
        SourceableFileExtension extension = options.getExtension();
        Path combined = path.resolve(extension.of(options.getPath()));

        return new LocalSource(combined,extension.getType(), options.getUsername(), options.getPassword());
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean isInstance(Producer producer) {
        return producer instanceof LocalSource;
    }
}
