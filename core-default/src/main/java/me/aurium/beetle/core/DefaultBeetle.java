package me.aurium.beetle.core;

import me.aurium.beetle.core.command.CommandRegistry;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.runner.TaskRunner;
import me.aurium.beetle.core.service.ServiceRegistry;

public class DefaultBeetle implements Beetle {

    private final TaskRunner runner;
    private final SimpleLogger simpleLogger;
    private final DataCoreFactory dataCoreFactory;
    private final ServiceRegistry classRegistry;
    private final CommandRegistry commandRegistry;

    public DefaultBeetle(TaskRunner taskRunner, SimpleLogger logger, DataCoreFactory dataCoreFactory, ServiceRegistry classRegistry, CommandRegistry commandRegistry) {
        this.runner = taskRunner;
        this.simpleLogger = logger;
        this.dataCoreFactory = dataCoreFactory;
        this.classRegistry = classRegistry;
        this.commandRegistry = commandRegistry;
    }

    public TaskRunner getTaskRunner() {
        return runner;
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

    public CommandRegistry getCommandRegistry() {
        return commandRegistry;
    }
}
