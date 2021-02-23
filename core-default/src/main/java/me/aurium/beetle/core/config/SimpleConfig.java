package me.aurium.beetle.core.config;

import java.io.File;

public class SimpleConfig implements DataHolder {

    private final File file;

    SimpleConfig(File file) {
        this.file = file;
    }

}
