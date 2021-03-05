package me.aurium.beetle.file.database;

import me.aurium.beetle.file.ProducerKey;

import java.nio.file.Path;

public class FSConfigProducerKey implements ProducerKey<FSConfigProducer, FSConfigProducerOptions> {

    private final String identifier;

    FSConfigProducerKey(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public FSConfigProducer newProducer(FSConfigProducerOptions options, Path path) {
        return new FSConfigProducer(path,options.getPassword(),options.getUser(),options.getDbname());
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Class<FSConfigProducer> getProducerClassType() {
        return FSConfigProducer.class;
    }

    public static FSConfigProducerKey of(String string) {
        return new FSConfigProducerKey(string);
    }
}
