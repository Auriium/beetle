package me.aurium.beetle;

import me.aurium.beetle.core.CommandRegisterable;
import me.aurium.beetle.core.DefaultBeetle;
import me.aurium.beetle.core.command.CommandRegistry;
import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.service.ServiceRegistry;
import me.aurium.beetle.core.task.Tasker;

public class VelocityBeetle extends DefaultBeetle implements CommandRegisterable<VelocityCommandData> {
    private final CommandRegistry<VelocityCommandData> commandRegistry;

    public VelocityBeetle(Tasker tasker, SimpleLogger logger, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, CommandRegistry<VelocityCommandData> commandRegistry, boolean isDebug) {
        super(tasker, logger, factory, serviceRegistry, fileProvider, isDebug);

        this.commandRegistry = commandRegistry;
    }

    @Override
    public CommandRegistry<VelocityCommandData> getCommandRegistry() {
        return commandRegistry;
    }
}
