package me.aurium.beetle.spigot;

import me.aurium.beetle.api.command.ContextSource;
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
    private final ContextSource<CommandSender> contextSource;

    SpigotBeetle(Tasker tasker, SimpleLogger logger, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, CommandRegistry<CommandSender> commandRegistry, ContextSource<CommandSender> context, boolean isDebug) {
        super(tasker, logger, factory, serviceRegistry, fileProvider, isDebug);

        this.commandRegistry = commandRegistry;
        this.contextSource = context;
    }

    @Override
    public CommandRegistry<CommandSender> getCommandRegistry() {
        return commandRegistry;
    }

    @Override
    public ContextSource<CommandSender> getCommandSource() {
        return contextSource;
    }
}
