package me.aurium.beetle.velocity;


import me.aurium.beetle.api.CommandRegisterable;
import me.aurium.beetle.api.command.CommandRegistry;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.file.FileProvider;
import me.aurium.beetle.api.service.ServiceRegistry;
import me.aurium.beetle.api.task.Tasker;
import me.aurium.beetle.defaults.CommonBeetle;

public class VelocityBeetle extends CommonBeetle implements CommandRegisterable<VelocityCommandData> {
    private final CommandRegistry<VelocityCommandData> commandRegistry;

    public VelocityBeetle(Tasker tasker, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, CommandRegistry<VelocityCommandData> commandRegistry, boolean isDebug) {
        super(tasker, factory, serviceRegistry, fileProvider, isDebug);

        this.commandRegistry = commandRegistry;
    }

    @Override
    public CommandRegistry<VelocityCommandData> getCommandRegistry() {
        return commandRegistry;
    }
}
