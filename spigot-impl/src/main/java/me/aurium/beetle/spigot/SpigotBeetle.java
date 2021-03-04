package me.aurium.beetle.spigot;

import me.aurium.beetle.core.CommandRegisterable;
import me.aurium.beetle.core.DefaultBeetle;
import me.aurium.beetle.core.command.CommandRegistry;
import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.service.ServiceRegistry;
import me.aurium.beetle.core.task.Tasker;
import me.aurium.beetle.spigot.command.SpigotCommandData;

public class SpigotBeetle extends DefaultBeetle implements CommandRegisterable<SpigotCommandData> {

    private final CommandRegistry<SpigotCommandData> commandRegistry;

    public SpigotBeetle(Tasker tasker, SimpleLogger logger, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, CommandRegistry<SpigotCommandData> commandRegistry, boolean isDebug) {
        super(tasker, logger, factory, serviceRegistry, fileProvider, isDebug);

        this.commandRegistry = commandRegistry;
    }

    @Override
    public CommandRegistry<SpigotCommandData> getCommandRegistry() {
        return commandRegistry;
    }
}
