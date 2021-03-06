package me.aurium.beetle.file.database;

import me.aurium.beetle.file.extension.LocalDataExtension;
import me.aurium.beetle.file.producer.ProducerOptions;

import java.nio.file.Path;

public class LocalSourceOptions implements ProducerOptions {

    private final LocalDataExtension extension;
    private final String username;
    private final String password;
    private final Path path;

    public LocalSourceOptions(String username, String password, LocalDataExtension extension, Path path) {
        this.username = username;
        this.password = password;
        this.extension = extension;
        this.path = path;
    }

    public LocalDataExtension getExtension() {
        return extension;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Path getPath() {
        return path;
    }



}
