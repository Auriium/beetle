package me.aurium.beetle.core;

import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.service.ServiceRegistry;
import me.aurium.beetle.core.task.Tasker;

public final class Beetle {

    private final Tasker tasker;
    private final SimpleLogger simpleLogger;
    private final DataCoreFactory dataCoreFactory;
    private final ServiceRegistry classRegistry;
    private final FileProvider fileProvider;
    private final boolean isDebug;

    public Beetle(Tasker tasker, SimpleLogger logger, DataCoreFactory dataCoreFactory, ServiceRegistry classRegistry, FileProvider provider, boolean isDebug) {
        this.simpleLogger = logger;
        this.dataCoreFactory = dataCoreFactory;
        this.classRegistry = classRegistry;
        this.fileProvider = provider;
        this.isDebug = isDebug;
        this.tasker = tasker;
    }

    public Tasker getTasker() {
        return this.tasker;
    }

    public SimpleLogger getLogger() {
        return simpleLogger;
    }

    public DataCoreFactory getDatacoreFactory() {
        return dataCoreFactory;
    }

    public ServiceRegistry getServiceRegistry() {
        return classRegistry;
    }

    public FileProvider getFileProvider() {
        return fileProvider;
    }

    public boolean isDebug() {
        return isDebug;
    }

}
