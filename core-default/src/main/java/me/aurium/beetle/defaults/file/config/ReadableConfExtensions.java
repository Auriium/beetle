package me.aurium.beetle.defaults.file.config;

import me.aurium.beetle.defaults.file.extension.ExtensionUtils;

import java.io.File;
import java.nio.file.Path;

/**
 * A collection of standard configuration extensions that come pre-swappable with Gears.
 *
 * Obviously, even though this is an enumerator you can implement your own confreadablefileextension and use it
 * for dumb ass file formats like toml or whatever.
 */
public enum ReadableConfExtensions implements ConfReadableFileExtension {

    YAML(".h2", new Reader() {
        @Override
        public InternalConfigMap read(File file) {
            return null;
        }
    });

    private final String key;
    private final Reader reader;

    ReadableConfExtensions(String key, Reader reader) {
        this.key = key;
        this.reader = reader;
    }

    @Override
    public Path of(Path path) {
        return ExtensionUtils.fromPath(path,key);
    }


    @Override
    public Reader getCorrespondingReader() {
        return reader;
    }
}
