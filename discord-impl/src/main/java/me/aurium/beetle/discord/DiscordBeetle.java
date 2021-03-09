package me.aurium.beetle.discord;

import me.aurium.beetle.CommonBeetle;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.file.FileProvider;
import me.aurium.beetle.api.logger.SimpleLogger;
import me.aurium.beetle.api.service.ServiceRegistry;
import me.aurium.beetle.api.task.Tasker;

public class DiscordBeetle extends CommonBeetle {
    public DiscordBeetle(Tasker tasker, SimpleLogger logger, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, boolean isDebug) {
        super(tasker, logger, factory, serviceRegistry, fileProvider, isDebug);
    }
}
