package me.aurium.beetle.defaults.file.database;

import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.file.producer.FileProvisioner;
import me.aurium.beetle.defaults.file.StateHolder;

import java.nio.file.Path;
import java.util.Optional;

public class LocalProvisioner implements FileProvisioner<CoreSource, LocalSourceAccessor> {

    private final StateHolder<CoreSource> coreSourceHolder;
    private final LocalSourceAccessor accessor;

    public LocalProvisioner(Path fullPathToObject, LocalSourceOptions options) {
        this.coreSourceHolder = new StateHolder<>();

        this.accessor = new LocalSourceAccessor(coreSourceHolder, fullPathToObject, options);
    }

    @Override
    public CoreSource access() {
        return coreSourceHolder.getHeld().orElseThrow(() -> new IllegalStateException("Attempted to access an unloaded coresource!"));
    }

    @Override
    public LocalSourceAccessor getAccessor() {
        return accessor;
    }
}
