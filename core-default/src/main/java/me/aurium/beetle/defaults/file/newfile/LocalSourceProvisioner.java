package me.aurium.beetle.defaults.file.newfile;

import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.file.UncheckedIOException;
import me.aurium.beetle.api.file.producer.ProvisionAccessor;
import me.aurium.beetle.defaults.file.StateHolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LocalSourceProvisioner implements ProvisionAccessor {

    private final StateHolder<CoreSource> stateHolder;

    private final Path fullPath;
    private final LocalSourceOptions options;


    public LocalSourceProvisioner(StateHolder<CoreSource> stateHolder, Path fullPath, LocalSourceOptions options) {
        this.stateHolder = stateHolder;
        this.fullPath = fullPath;
        this.options = options;
    }

    @Override
    public void load() {
        File file = fullPath.toFile();

        try {
            if (!file.createNewFile()) {
                throw new IOException("Database file already exists!");
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e); //lovely thing checked exceptions are.
        }

        stateHolder.setHeld(
                options.getExtensionType().getType().asFactory(file, options.getUsername(), options.getPassword(), options.getTimeout()).getCoreSource()
        );
    }
}
