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
    public Path pathPlease() {
        return path;
    }

    @Override
    public LocalDBType getCorrespondingCoreSource() {
        return LocalDBType.H2;
    }

    public static YMLExtension of(Path path) {
        return new YMLExtension(ExtensionUtils.fromPath(path,KEY));
    }

    public static YMLExtension of(String string) {
        return of(Path.of(string));
    }
}
