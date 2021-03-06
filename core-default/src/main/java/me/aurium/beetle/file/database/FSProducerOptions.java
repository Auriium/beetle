package me.aurium.beetle.file.database;

import me.aurium.beetle.file.extension.LocalStorageExtension;
import me.aurium.beetle.file.producer.ProducerOptions;

import java.nio.file.Path;

public class FSProducerOptions implements ProducerOptions {

    private final String username;
    private final String password;
    private final LocalStorageExtension storageExtension;

    public FSProducerOptions(String username, String password, LocalStorageExtension extension) {
        this.username = username;
        this.password = password;
        this.storageExtension = extension;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalStorageExtension getStorageExtension() {
        return storageExtension;
    }



}
