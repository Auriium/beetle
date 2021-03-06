package me.aurium.beetle;

import me.aurium.beetle.datacore.DataCoreFactory;
import me.aurium.beetle.file.FileProvider;
import me.aurium.beetle.logger.SimpleLogger;
import me.aurium.beetle.service.ServiceRegistry;
import me.aurium.beetle.task.Tasker;

/**
 * Collection of unified subutilities. Keep in mind that the beetle simply unified the subutilities, if you want to use them
 * elsewhere individually it is completely possible to do so (provided you pass them their dependencies)
 */
public interface Beetle {

    Tasker getTasker();
    SimpleLogger getLogger();
    DataCoreFactory getDataCoreFactory();
    ServiceRegistry getServiceRegistry();
    FileProvider getFileProvider();

    boolean isDebug();

}
