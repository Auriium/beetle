package me.aurium.beetle.defaults.file.database;

import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.defaults.datacore.LocalDB;
import me.aurium.beetle.api.file.UncheckedIOException;
import me.aurium.beetle.api.file.producer.FileData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LocalSource implements FileData {

    private final Path filePathExact;
    private final String username;
    private final String password;
    private final LocalDB type;

    public LocalSource(Path filePathExact, LocalDB type, String username, String password) {
        this.filePathExact = filePathExact;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public CoreSource produce() {

        File file = filePathExact.toFile();

        try {
            if (!file.createNewFile()) {
                throw new IOException("Database file already exists!");
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e); //lovely thing checked exceptions are.
        }

        return type.asFactory(file,username,password).getCoreSource();
    }

}
