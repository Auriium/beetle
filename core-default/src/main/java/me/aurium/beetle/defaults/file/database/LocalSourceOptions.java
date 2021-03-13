package me.aurium.beetle.defaults.file.database;

import me.aurium.beetle.api.file.producer.FileDataOptions;

import java.nio.file.Path;
import java.util.Optional;

public class LocalSourceOptions implements FileDataOptions {

    private final SourceableFileExtension extension;
    private final String username;
    private final String password;
    private final Path path;
    private final int timeout;

    public LocalSourceOptions(String username, String password, SourceableFileExtension extension, Path path) {
        this.username = username;
        this.password = password;
        this.extension = extension;
        this.path = path;
        this.timeout = 60;
    }

    public LocalSourceOptions(String username, String password, SourceableFileExtension extension, String path) {
        this.username = username;
        this.password = password;
        this.extension = extension;
        this.path = Path.of(path);
        this.timeout = 60;
    }

    public LocalSourceOptions(String username, String password, SourceableFileExtension extension, String path, int timeout) {
        this.username = username;
        this.password = password;
        this.extension = extension;
        this.path = Path.of(path);
        this.timeout = timeout;
    }

    public LocalSourceOptions(String username, String password, SourceableFileExtension extension) {
        this.username = username;
        this.password = password;
        this.extension = extension;
        this.path = null;
        this.timeout = 60;
    }

    public SourceableFileExtension getExtension() {
        return extension;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Optional<Path> getPath() {
        return Optional.ofNullable(path);
    }

    public int getTimeout() {
        return timeout;
    }



}
