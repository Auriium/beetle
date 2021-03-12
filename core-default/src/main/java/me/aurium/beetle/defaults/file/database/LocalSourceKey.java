package me.aurium.beetle.defaults.file.database;

import me.aurium.beetle.api.file.producer.FileData;
import me.aurium.beetle.api.file.producer.FileDataKey;

import java.nio.file.Path;

public class LocalSourceKey implements FileDataKey<LocalSource,LocalSourceOptions> {

    private final String identifier;

    public LocalSourceKey(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public LocalSource newProducer(LocalSourceOptions options, Path path) {
        SourceableFileExtension extension = options.getExtension();

        Path combined;

        if (options.getPath().isEmpty()) {
            combined = path.resolve(extension.of(Path.of(identifier)));
        } else {
            combined = path.resolve(extension.of(options.getPath().get()));
        }

        return new LocalSource(combined,extension.getType(), options.getUsername(), options.getPassword());
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean isInstance(FileData fileData) {
        return fileData instanceof LocalSource;
    }
}
