package me.aurium.beetle.defaults.file;

import me.aurium.beetle.api.file.FileCreator;
import me.aurium.beetle.api.file.producer.CreationOptions;
import me.aurium.beetle.api.file.producer.FileProvisioner;

import java.nio.file.Path;

/**
 * Really simple creator
 */
public class CommonCreator implements FileCreator {

    private final Path basePath;

    public CommonCreator(Path basePath) {
        this.basePath = basePath;
    }

    @Override
    public <T extends FileProvisioner<?, ?>> T create(CreationOptions<T> options) {
        return options.newProducer(basePath);
    }
}
