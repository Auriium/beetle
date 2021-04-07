package me.aurium.beetle.defaults.file.storage;

import me.aurium.beetle.api.file.data.StorageProvisioner;
import me.aurium.beetle.api.file.producer.CreationOptions;

import java.nio.file.Path;

public abstract class StorageOptions<T> implements CreationOptions<StorageProvisioner<T>> {

    protected abstract void save(Path path, T t);
    protected abstract T load(Path path);

    @Override
    public StorageProvisioner<T> newProducer(Path basePath) {
        return new CommonStorageProvisioner<>(basePath,this);
    }
}
