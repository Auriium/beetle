package me.aurium.beetle.defaults.datacore;

import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.datacore.CoreSourceFactory;

public class FileCoreSourceFactory implements CoreSourceFactory {

    private final FileSourceConfig file;
    private final String driverClassPath;
    private final String driverName;

    public FileCoreSourceFactory(FileSourceConfig file, String driverClassPath, String driverName) {
        this.file = file;
        this.driverClassPath = driverClassPath;
        this.driverName = driverName;
    }


    @Override
    public CoreSource getCoreSource() {

        try {
            Class.forName(driverClassPath);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(driverName + " Driver is missing from the plugin that a CoreSource as built on!");
        }

        String address = String.format("jdbc:%s:" + file.getFile(), driverName);

        return new AddressCoreSource(address,file.getUsername(), file.getUsername());
    }


}
