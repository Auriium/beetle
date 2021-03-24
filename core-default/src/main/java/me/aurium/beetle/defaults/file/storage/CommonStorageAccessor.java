package me.aurium.beetle.defaults.file.storage;

import me.aurium.beetle.api.file.UncheckedIOException;
import me.aurium.beetle.api.file.data.StorageUnitAccessor;
import me.aurium.beetle.defaults.file.StateHolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class CommonStorageAccessor<T> implements StorageUnitAccessor<T> {

    private final Path fullPath;
    private final StateHolder<T> holder;
    private final StorageOptions<T> options;

    public CommonStorageAccessor(Path fullPath, StateHolder<T> holder, StorageOptions<T> options) {
        this.fullPath = fullPath;
        this.holder = holder;
        this.options = options;
    }

    @Override
    public void save() {
        File file = fullPath.toFile();

        try {
            if (!file.exists()) {
                boolean ignored = file.createNewFile();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e); //lovely thing checked exceptions are.
        }

        options.save(fullPath, holder.getHeld().orElseThrow(() -> new IllegalStateException("Tried to save common storage accessor with empty holder!")));
    }

    @Override
    public void load() {
        File file = fullPath.toFile();

        try {
            if (!file.exists()) {
                boolean ignored = file.createNewFile();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e); //lovely thing checked exceptions are.
        }

        holder.setHeld(options.load(fullPath));
    }
}
