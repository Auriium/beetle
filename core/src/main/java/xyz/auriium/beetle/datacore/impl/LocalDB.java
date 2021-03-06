package xyz.auriium.beetle.datacore.impl;

import java.io.File;

public interface LocalDB {

    String getDriverName();
    String getDriverClasspath();

    FileCoreSourceFactory asFactory(FileSourceConfig config);
    FileCoreSourceFactory asFactory(File file, String username, String password, int timeout);
    FileCoreSourceFactory asFactory(File file, String username, String password);

}
