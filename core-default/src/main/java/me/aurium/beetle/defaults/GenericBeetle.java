package me.aurium.beetle.defaults;

import me.aurium.beetle.api.capability.Taskable;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.service.ServiceRegistry;
import me.aurium.beetle.api.task.Tasker;

public class GenericBeetle extends AbstractBeetle implements Taskable<Tasker> {
    private final Tasker tasker;

    public GenericBeetle(DataCoreFactory factory, ServiceRegistry serviceRegistry, FileProvider fileProvider, Tasker tasker, boolean isDebug) {
        super(factory, serviceRegistry, fileProvider, isDebug);

        this.tasker = tasker;
    }

    @Override
    public Tasker getTasker() {
        return tasker;
    }
}
