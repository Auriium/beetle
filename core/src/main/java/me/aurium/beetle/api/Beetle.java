package me.aurium.beetle.api;

import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.service.ServiceRegistry;

/**
 * Collection of unified subutilities. Keep in mind that the beetle simply unified the subutilities, if you want to use them
 * elsewhere individually it is completely possible to do so (provided you pass them their dependencies)
 */
public interface Beetle {

    DataCoreFactory getDataCoreFactory();
    ServiceRegistry getServiceRegistry();

    boolean isDebug();

}
