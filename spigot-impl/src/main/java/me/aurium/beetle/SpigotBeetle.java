package me.aurium.beetle;

import me.aurium.beetle.command.CommandRegistry;
import me.aurium.beetle.datacore.DataCoreFactory;
import me.aurium.beetle.file.FileProvider;
import me.aurium.beetle.logger.SimpleLogger;
import me.aurium.beetle.service.ServiceRegistry;
import me.aurium.beetle.task.Tasker;
import me.aurium.beetle.command.SpigotCommandData;

public class SpigotBeetle extends CommonBeetle implements CommandRegisterable<SpigotCommandData> {

    private final CommandRegistry<SpigotCommandData> commandRegistry;

    SpigotBeetle(Tasker tasker, SimpleLogger logger, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, CommandRegistry<SpigotCommandData> commandRegistry, boolean isDebug) {
        super(tasker, logger, factory, serviceRegistry, fileProvider, isDebug);

        this.commandRegistry = commandRegistry;
    }

    @Override
    public CommandRegistry<SpigotCommandData> getCommandRegistry() {
        return commandRegistry;
    }
}
