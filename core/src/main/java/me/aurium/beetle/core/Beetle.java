package me.aurium.beetle.core;

import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.runner.TaskRunner;

/**
 * Represents the lifecycle of a Beetle Utility System with all systems active.
 * Contains taskrunners and factories for certain SubSystems.
 */
public interface Beetle {

    //Single Services
    TaskRunner getTaskRunner();
    SimpleLogger getLogger();

    //Provider Services
    DataCoreFactory getDatacoreFactory();

}
