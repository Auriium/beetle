package me.aurium.beetle.core;

import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.runner.TaskRunner;
import me.aurium.beetle.core.service.ServiceRegistry;

public interface Beetle {

    TaskRunner getTaskRunner();
    SimpleLogger getLogger();

    DataCoreFactory getDatacoreFactory();
    ServiceRegistry getServiceRegistry();
    FileProvider getFileProvider();

    boolean isDebug();

}
