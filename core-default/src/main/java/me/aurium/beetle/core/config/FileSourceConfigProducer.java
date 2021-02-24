package me.aurium.beetle.core.config;

import me.aurium.beetle.core.datacore.FileSourceConfig;

import java.io.File;
import java.io.IOException;

public class FileSourceConfigProducer implements FileProducer<FileSourceConfig> {

    private final String password;
    private final String username;

    public FileSourceConfigProducer(String password, String username) {
        this.password = password;
        this.username = username;
    }

    @Override
    public FileSourceConfig produce(File file) throws IOException {

        System.out.println(file.getAbsolutePath());

        if (!file.exists()) {
            file.createNewFile();
        }

        return new FileSourceConfig(file,username,password);
    }

}
