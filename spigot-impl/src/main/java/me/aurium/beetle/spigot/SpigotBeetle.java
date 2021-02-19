package me.aurium.beetle.spigot;

import me.aurium.beetle.core.Beetle;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.runner.TaskRunner;

public class SpigotBeetle implements Beetle {

    SpigotBeetle(TaskRunner taskRunner) {

    }

    @Override
    public TaskRunner getTaskRunner() {
        return null;
    }

    @Override
    public SimpleLogger getLogger() {
        return null;
    }

    @Override
    public DataCoreFactory getDatacoreFactory() {
        return null;
    }
}
