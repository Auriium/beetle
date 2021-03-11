package me.aurium.beetle.spigot;

import me.aurium.beetle.defaults.CommonBeetle;
import me.aurium.beetle.api.CommandRegisterable;
import me.aurium.beetle.api.command.CommandRegistry;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.file.FileProvider;
import me.aurium.beetle.api.logger.SimpleLogger;
import me.aurium.beetle.api.service.ServiceRegistry;
import me.aurium.beetle.api.task.Tasker;
import org.bukkit.command.CommandSender;

public class SpigotBeetle extends CommonBeetle implements CommandRegisterable<CommandSender> {

    private final CommandRegistry<CommandSender> commandRegistry;

    SpigotBeetle(Tasker tasker, SimpleLogger logger, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, CommandRegistry<CommandSender> commandRegistry, boolean isDebug) {
        super(tasker, logger, factory, serviceRegistry, fileProvider, isDebug);

        this.commandRegistry = commandRegistry;
    }

    @Override
    public CommandRegistry<CommandSender> getCommandRegistry() {
        return commandRegistry;
    }

}
