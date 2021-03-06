package me.aurium.beetle.file.extension;

import me.aurium.beetle.datacore.FileCoreSourceFactory;
import me.aurium.beetle.datacore.LocalDBType;

import java.nio.file.Path;

public class H2Extension implements LocalStorageExtension{

    public static String KEY = ".h2";

    private final Path path;

    H2Extension(Path path) {
        this.path = path;
    }

    @Override
    public Path getSeveredPath() {
        return path;
    }

    @Override
    public Path getCombinedPath(Path path) {
        return path.resolve(this.path);
    }

    @Override
    public LocalDBType getCorrespondingCoreSource() {
        return LocalDBType.H2;
    }

    public static H2Extension of(Path path) {
        return new H2Extension(ExtensionUtils.fromPath(path,KEY));
    }

    public static H2Extension of(String string) {
        return of(Path.of(string));
    }
}
