package me.aurium.beetle.file.extension;

import me.aurium.beetle.datacore.LocalDBType;

import java.nio.file.Path;

public enum LocalStorageExtensions implements LocalDataExtension {

    H2(".h2",LocalDBType.H2),
    DB(".db",LocalDBType.SQLite);

    private final String key;
    private final LocalDBType dbType;

    LocalStorageExtensions(String key, LocalDBType dbType) {
        this.dbType = dbType;
        this.key = key;
    }

    @Override
    public Path of(Path path) {
        return ExtensionUtils.fromPath(path,key);
    }

    @Override
    public LocalDBType getType() {
        return dbType;
    }
}
