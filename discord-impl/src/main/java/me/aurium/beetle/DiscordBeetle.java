package me.aurium.beetle;

import me.aurium.beetle.datacore.DataCoreFactory;
import me.aurium.beetle.file.FileProvider;
import me.aurium.beetle.logger.SimpleLogger;
import me.aurium.beetle.service.ServiceRegistry;
import me.aurium.beetle.task.Tasker;

public class DiscordBeetle extends CommonBeetle {
    public DiscordBeetle(Tasker tasker, SimpleLogger logger, DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, boolean isDebug) {
        super(tasker, logger, factory, serviceRegistry, fileProvider, isDebug);
    }
}
