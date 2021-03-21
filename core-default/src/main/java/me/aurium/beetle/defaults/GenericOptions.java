package me.aurium.beetle.defaults;

import me.aurium.beetle.api.BeetleOptions;
import me.aurium.beetle.api.task.sync.BlockingBehavior;

import java.util.concurrent.ExecutorService;

public class GenericOptions implements BeetleOptions {

    private final ExecutorService utilizedService;
    private final BlockingBehavior behavior;

    public GenericOptions(ExecutorService utilizedService, BlockingBehavior behavior) {
        this.utilizedService = utilizedService;
        this.behavior = behavior;
    }

    public ExecutorService getUtilizedService() {
        return utilizedService;
    }
}
