package me.aurium.beetle.defaults.file;

import me.aurium.beetle.api.file.FileProvider;
import me.aurium.beetle.api.file.NonexistentDataException;
import me.aurium.beetle.api.file.DataAlreadyRegisteredException;
import me.aurium.beetle.api.file.WrongProducerTypeException;
import me.aurium.beetle.api.file.producer.FileData;
import me.aurium.beetle.api.file.producer.FileDataKey;
import me.aurium.beetle.api.file.producer.FileDataOptions;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CommonFileProvider implements FileProvider {

    private final Path localPath;
    private final Map<String, FileData> internalMap;

    public CommonFileProvider(Path localPath) {
        this.localPath = localPath;
        this.internalMap = new HashMap<>();
    }


    @Override
    public <T extends FileDataOptions, C extends FileData> C registerNewData(FileDataKey<C, T> producer, T options, Path path) {
        String identifier = producer.getIdentifier();

        if (internalMap.containsKey(identifier)) {
            throw new DataAlreadyRegisteredException(identifier);
        }

        C wonk = producer.newProducer(options,path);

        internalMap.put(identifier,wonk);

        return wonk;
    }

    @Override
    public <T extends FileDataOptions, C extends FileData> C registerNewData(FileDataKey<C, T> producer, T options, String path) {
        return registerNewData(producer,options,Path.of(path));
    }

    @Override
    public <T extends FileDataOptions, C extends FileData> C registerNewData(FileDataKey<C, T> producer, T options) {
        return registerNewData(producer, options, localPath);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends FileData> T getData(FileDataKey<T, ?> key) {

        FileData fileData = internalMap.get(key.getIdentifier());

        if (fileData == null) throw new NonexistentDataException();

        if (!key.isInstance(fileData)) throw new WrongProducerTypeException();

        return (T) fileData;

    }
}
