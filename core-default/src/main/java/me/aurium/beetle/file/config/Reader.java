package me.aurium.beetle.file.config;

import java.io.File;

public interface Reader {

    InternalConfigMap read(File file);

}
