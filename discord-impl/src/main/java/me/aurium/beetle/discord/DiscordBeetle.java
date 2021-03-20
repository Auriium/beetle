package me.aurium.beetle.discord;

import me.aurium.beetle.defaults.CommonBeetle;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.file.FileProvider;
import me.aurium.beetle.api.service.ServiceRegistry;
import me.aurium.beetle.api.task.Tasker;

public class DiscordBeetle extends CommonBeetle {
    public DiscordBeetle(Tasker tasker, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, boolean isDebug) {
        super(tasker, factory, serviceRegistry, fileProvider, isDebug);
    }
}
