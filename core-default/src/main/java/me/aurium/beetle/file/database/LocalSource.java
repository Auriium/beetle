package me.aurium.beetle.file.database;

import me.aurium.beetle.datacore.CoreSource;
import me.aurium.beetle.datacore.LocalDBType;
import me.aurium.beetle.file.UncheckedIOException;
import me.aurium.beetle.file.producer.Producer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LocalSource implements Producer {

    private final Path filePathExact;
    private final String username;
    private final String password;
    private final LocalDBType type;

    public LocalSource(Path filePathExact, LocalDBType type, String username, String password) {
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
