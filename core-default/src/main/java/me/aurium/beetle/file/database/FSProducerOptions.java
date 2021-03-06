package me.aurium.beetle.file.database;

import me.aurium.beetle.file.producer.ProducerOptions;

import java.nio.file.Path;

public class FSProducerOptions implements ProducerOptions {

    private final String username;
    private final String password;
    private final FSProducer.Type type;
    private final FileEndings.DB dbFile;

    public FSProducerOptions(String username, String password, FSProducer.Type type, FileEndings.DB dbFile) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.dbFile = dbFile;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public FSProducer.Type getType() {
        return type;
    }

    public Path getEndingPath() {
        return dbFile.toPath();
    }



}
