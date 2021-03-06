package me.aurium.beetle.file;

import me.aurium.beetle.file.producer.Producer;
import me.aurium.beetle.file.producer.ProducerKey;
import me.aurium.beetle.file.producer.ProducerOptions;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CommonFileProvider implements FileProvider {

    private final Path localPath;
    private final Map<String, Producer> internalMap;

    public CommonFileProvider(Path localPath) {
        this.localPath = localPath;
        this.internalMap = new HashMap<>();
    }


    @Override
    public <T extends ProducerOptions> void registerNewFileProducer(ProducerKey<?, T> producer, T options, Path path) {
        String identifier = producer.getIdentifier();

        if (internalMap.containsKey(identifier)) {
            throw new ProducerAlreadyRegisteredException(identifier);
        }

        Producer wonk = producer.newProducer(options,path);

        internalMap.put(identifier,wonk);
    }

    @Override
    public <T extends ProducerOptions> void registerNewFileProducer(ProducerKey<?, T> producer, T options, String path) {
        registerNewFileProducer(producer,options,Path.of(path));
    }

    @Override
    public <T extends ProducerOptions> void registerNewFileProducer(ProducerKey<?, T> producer, T options) {
        registerNewFileProducer(producer, options, localPath);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Producer> T getProducer(ProducerKey<T, ?> key) {

        Producer producer = internalMap.get(key.getIdentifier());

        if (producer == null) throw new NonexistentProducerException();

        if (!key.isInstance(producer)) throw new WrongProducerTypeException();

        return (T) producer;

    }
}
