package me.aurium.beetle.file.database;

import me.aurium.beetle.datacore.CoreSource;
import me.aurium.beetle.datacore.FileCoreSourceFactory;
import me.aurium.beetle.datacore.FileSourceConfig;
import me.aurium.beetle.datacore.LocalDBType;
import me.aurium.beetle.file.producer.Producer;
import me.aurium.beetle.file.UncheckedIOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FSProducer implements Producer {

    private final Path filePathExact;
    private final String username;
    private final String password;
    private final LocalDBType type;

    public FSProducer(Path filePathExact, String username, String password, LocalDBType type) {
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
