package me.aurium.beetle.spigot;

import me.aurium.beetle.api.capability.CommandRegisterable;
import me.aurium.beetle.api.capability.Taskable;
import me.aurium.beetle.api.command.CommandRegistry;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.file.FileProvider;
import me.aurium.beetle.api.service.ServiceRegistry;
import me.aurium.beetle.defaults.AbstractBeetle;
import org.bukkit.command.CommandSender;

public class SpigotBeetle extends AbstractBeetle implements CommandRegisterable<CommandSender>, Taskable<SpigotTasker> {

    private final CommandRegistry<CommandSender> registry;
    private final SpigotTasker tasker;

    public SpigotBeetle(CommandRegistry<CommandSender> registry, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, SpigotTasker tasker, boolean isDebug) {
        super(factory, serviceRegistry, fileProvider, isDebug);

        this.tasker = tasker;
        this.registry = registry;
    }


    @Override
    public CommandRegistry<CommandSender> getCommandRegistry() {
        return registry;
    }

    @Override
    public SpigotTasker getTasker() {
        return tasker;
    }
}
