package xyz.auriium.beetle.file.extension.database;

import xyz.auriium.beetle.datacore.CoreSource;
import xyz.auriium.beetle.file.StateHolder;
import xyz.auriium.beetle.file.FileProvisioner;

import java.nio.file.Path;

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
