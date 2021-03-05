package me.aurium.beetle;

import me.aurium.beetle.datacore.DataCoreFactory;
import me.aurium.beetle.file.FileProvider;
import me.aurium.beetle.logger.SimpleLogger;
import me.aurium.beetle.service.ServiceRegistry;
import me.aurium.beetle.task.Tasker;

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
