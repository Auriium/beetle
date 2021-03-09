package me.aurium.beetle.defaults.file.config;

import java.io.File;

public interface Reader {

    InternalConfigMap read(File file);

}
