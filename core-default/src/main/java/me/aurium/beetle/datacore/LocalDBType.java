package me.aurium.beetle.datacore;

import java.io.File;

/**
 * Represents a local database type. Make a pull request if you find another local sql type i haven't included here that operates similarily.
 *
 * I will not add microsoftsql
 * TODO add one of these for hikaricoresources
 */
public enum LocalDBType {

    SQLite("org.sqlite.jdbc","sqlite"),
    H2("org.h2.driver","h2");

    private final String driverClasspath;
    private final String driverName;

    LocalDBType(String driverClasspath, String driverName) {
        this.driverClasspath = driverClasspath;
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverClasspath() {
        return driverClasspath;
    }

    public FileCoreSourceFactory asFactory(FileSourceConfig config) {
        return new FileCoreSourceFactory(config,driverClasspath,driverName);
    }

    public FileCoreSourceFactory asFactory(File file, String username, String password) {
        return new FileCoreSourceFactory(new FileSourceConfig(file, username, password),driverClasspath,driverName);
    }

}
