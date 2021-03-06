package me.aurium.beetle.file.database;

import me.aurium.beetle.file.producer.Producer;
import me.aurium.beetle.file.producer.ProducerKey;

import java.nio.file.Path;

public class FSProducerKey implements ProducerKey<FSProducer,FSProducerOptions> {

    private final String identifier;

    FSProducerKey(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public FSProducer newProducer(FSProducerOptions options, Path path) {
        Path fullPath = path.resolve(options.getStorageExtension().getSeveredPath());

        return new FSProducer(path, options.getUsername(), options.getPassword(), options.getStorageExtension().getCorrespondingCoreSource());
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean isInstance(Producer producer) {
        return producer instanceof FSProducer;
    }

    public static FSProducerKey of(String identifier) {
        return new FSProducerKey(identifier);
    }
}
