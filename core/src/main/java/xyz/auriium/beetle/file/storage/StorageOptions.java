package xyz.auriium.beetle.file.storage;

import xyz.auriium.beetle.file.CreationOptions;

import java.nio.file.Path;

public abstract class StorageOptions<T> implements CreationOptions<StorageProvisioner<T>> {

    protected abstract void save(Path path, T t);
    protected abstract T load(Path path);

    @Override
    public StorageProvisioner<T> newProducer(Path basePath) {
        return new CommonStorageProvisioner<>(basePath,this);
    }
}
