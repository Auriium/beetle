package me.aurium.beetle.defaults.datacore;

import java.io.File;

/**
 * Represents a local database type. Make a pull request if you find another local sql type i haven't included here that operates similarily.
 *
 * I will not add microsoftsql
 * TODO add one of these for hikaricoresources
 */
public enum LocalDBConstants implements LocalDB {

    SQLite("org.sqlite.jdbc","sqlite"),
    H2("org.h2.driver","h2");

    private final String driverClasspath;
    private final String driverName;

    LocalDBConstants(String driverClasspath, String driverName) {
        this.driverClasspath = driverClasspath;
        this.driverName = driverName;
    }

    @Override
    public String getDriverName() {
        return driverName;
    }

    @Override
    public String getDriverClasspath() {
        return driverClasspath;
    }

    @Override
    public FileCoreSourceFactory asFactory(FileSourceConfig config) {
        return new FileCoreSourceFactory(config,driverClasspath,driverName);
    }

    @Override
    public FileCoreSourceFactory asFactory(File file, String username, String password, int timeout) {
        return new FileCoreSourceFactory(new FileSourceConfig(file, username, password, timeout),driverClasspath,driverName);
    }

    @Override
    public FileCoreSourceFactory asFactory(File file, String username, String password) {
        return asFactory(file, username, password, 60);
    }

}
