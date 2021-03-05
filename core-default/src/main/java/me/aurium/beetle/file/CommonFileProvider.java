package me.aurium.beetle.file;

import me.aurium.beetle.file.*;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CommonFileProvider implements FileProvider {

    private final Path localPath;
    private final Map<String, DataProducer<?>> internalMap;

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

        DataProducer<?> wonk = producer.newProducer(options,path);
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
    public <T extends DataProducer<?>> T getProducer(ProducerKey<T, ?> key) {

        DataProducer<?> producer = internalMap.get(key.getIdentifier());

        if (producer == null) throw new NonexistentProducerException();

        Class<T> expectedType = key.getProducerClassType();

        if (!(producer.getClass() == expectedType)) throw new WrongProducerTypeException(expectedType);

        return (T) producer;

    }
}
