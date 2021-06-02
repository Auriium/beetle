package xyz.auriium.beetle.file.storage;

import xyz.auriium.beetle.file.StateHolder;

import java.nio.file.Path;

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
