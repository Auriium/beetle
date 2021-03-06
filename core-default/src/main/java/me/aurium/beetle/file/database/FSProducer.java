package me.aurium.beetle.file.database;

import me.aurium.beetle.datacore.CoreSource;
import me.aurium.beetle.datacore.FileCoreSourceFactory;
import me.aurium.beetle.datacore.FileSourceConfig;
import me.aurium.beetle.file.producer.Producer;
import me.aurium.beetle.file.UncheckedIOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FSProducer implements Producer {

    private final Path filePathExact;
    private final String username;
    private final String password;
    private final Type type;

    public FSProducer(Path filePathExact, String username, String password, Type type) {
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


        switch(type) {
            case H2:
                return new FileCoreSourceFactory.H2(new FileSourceConfig(file,username,password)).getCoreSource();
            case SQLite:
                return new FileCoreSourceFactory.SQLite(new FileSourceConfig(file,username,password)).getCoreSource();
            default:
                throw new RuntimeException("Unknown database type!");
        }
    }

    public enum Type {
        H2,SQLite
    }
}
