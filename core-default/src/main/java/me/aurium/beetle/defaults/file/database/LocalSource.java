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
    private final int timeout;

    public LocalSource(Path filePathExact, LocalDB type, String username, String password, int timeout) {
        this.filePathExact = filePathExact;
        this.username = username;
        this.password = password;
        this.type = type;
        this.timeout = timeout;
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

        return type.asFactory(file,username,password,timeout).getCoreSource();
    }

}
