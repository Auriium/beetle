package me.aurium.beetle.file.config;

import me.aurium.beetle.file.extension.ExtensionUtils;

import java.nio.file.Path;

public enum ConfigExtensions implements ConfigurableFileExtension {

    H2(".h2"),
    DB(".db");

    private final String key;

    ConfigExtensions(String key) {
        this.key = key;
    }

    @Override
    public Path of(Path path) {
        return ExtensionUtils.fromPath(path,key);
    }



}
