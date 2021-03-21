package me.aurium.beetle.defaults;

import me.aurium.beetle.api.Beetle;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.file.FileProvider;
import me.aurium.beetle.api.service.ServiceRegistry;
import me.aurium.beetle.api.task.Tasker;

public abstract class AbstractBeetle implements Beetle {

    private final DataCoreFactory factory;
    private final ServiceRegistry serviceRegistry;
    private final FileProvider fileProvider;
    private final boolean isDebug;

    public AbstractBeetle(DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, boolean isDebug) {
        this.serviceRegistry = serviceRegistry;
        this.fileProvider = fileProvider;
        this.factory = factory;
        this.isDebug = isDebug;
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
