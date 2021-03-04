package me.aurium.beetle.core;

import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.service.ServiceRegistry;
import me.aurium.beetle.core.task.Tasker;

public class DefaultBeetle implements Beetle{

    private final Tasker tasker;
    private final SimpleLogger logger;
    private final DataCoreFactory factory;
    private final ServiceRegistry serviceRegistry;
    private final FileProvider fileProvider;
    private final boolean isDebug;

    public DefaultBeetle(Tasker tasker, SimpleLogger logger, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, boolean isDebug) {
        this.tasker = tasker;
        this.logger = logger;
        this.serviceRegistry = serviceRegistry;
        this.fileProvider = fileProvider;
        this.factory = factory;
        this.isDebug = isDebug;
    }


    @Override
    public Tasker getTasker() {
        return tasker;
    }

    @Override
    public SimpleLogger getLogger() {
        return logger;
    }

    @Override
    public DataCoreFactory getDataCoreFactory() {
        return factory;
    }

    @Override
    public ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }

    @Override
    public FileProvider getFileProvider() {
        return fileProvider;
    }

    @Override
    public boolean isDebug() {
        return isDebug;
    }
}
