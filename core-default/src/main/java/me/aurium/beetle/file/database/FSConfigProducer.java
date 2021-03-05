package me.aurium.beetle.file.database;

import me.aurium.beetle.datacore.FileSourceConfig;
import me.aurium.beetle.file.DataProducer;
import me.aurium.beetle.file.SaveableProducer;
import me.aurium.beetle.file.UncheckedIOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FSConfigProducer implements DataProducer<FileSourceConfig> {

    private final String password;
    private final String username;
    private final Path path;

    FSConfigProducer(Path path, String password, String username) {
        this.password = password;
        this.username = username;
        this.path = path;
    }

    @Override
    public FileSourceConfig produce() {

        File file = path.toFile();

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new UncheckedIOException(e); //lovely thing checked exceptions are.
            }

        }

        return new FileSourceConfig(file,username,password);

    }

}
