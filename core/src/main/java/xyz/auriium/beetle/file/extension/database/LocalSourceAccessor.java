package xyz.auriium.beetle.file.extension.database;

import xyz.auriium.beetle.datacore.CoreSource;
import xyz.auriium.beetle.file.StateHolder;
import xyz.auriium.beetle.file.ProvisionAccessor;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;

public class LocalSourceAccessor implements ProvisionAccessor {

    private final StateHolder<CoreSource> stateHolder;

    private final Path fullPath;
    private final LocalSourceOptions options;


    public LocalSourceAccessor(StateHolder<CoreSource> stateHolder, Path fullPath, LocalSourceOptions options) {
        this.stateHolder = stateHolder;
        this.fullPath = fullPath;
        this.options = options;
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

        stateHolder.setHeld(
                options.getExtensionType().getType().asFactory(file, options.getUsername(), options.getPassword(), options.getTimeout()).getCoreSource()
        );
    }
}
