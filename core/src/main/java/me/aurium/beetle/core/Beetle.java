package me.aurium.beetle.core;

import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.service.ServiceRegistry;
import me.aurium.beetle.core.task.Tasker;

/**
 * Internal Beetle interface
 */
public interface Beetle {

    Tasker getTasker();
    SimpleLogger getLogger();
    DataCoreFactory getDataCoreFactory();
    ServiceRegistry getServiceRegistry();
    FileProvider getFileProvider();

    boolean isDebug();

}
