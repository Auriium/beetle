package me.aurium.beetle.defaults.file.storage;

import me.aurium.beetle.api.file.data.StorageProvisioner;
import me.aurium.beetle.api.file.data.StorageUnitAccessor;
import me.aurium.beetle.defaults.file.StateHolder;

import java.nio.file.Path;
import java.util.Optional;

public class CommonStorageProvisioner<T> implements StorageProvisioner<T> {

    private final StateHolder<T> stateHolder;
    private final StorageUnitAccessor<T> storageAccessor;

    public CommonStorageProvisioner(Path fullPathToObject, StorageOptions<T> options) {
        this.stateHolder = new StateHolder<>();

        this.storageAccessor = new CommonStorageAccessor<>(fullPathToObject,stateHolder,options);
    }

    @Override
    public T access() {
        return stateHolder.getHeld().orElseThrow(() -> new IllegalStateException("Attempted to get from held when object was not loaded!"));
    }

    @Override
    public StorageUnitAccessor<T> getAccessor() {
        return storageAccessor;
    }
}
