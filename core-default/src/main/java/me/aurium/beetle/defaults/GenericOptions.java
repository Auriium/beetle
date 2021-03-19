package me.aurium.beetle.defaults;

import me.aurium.beetle.api.BeetleOptions;

import java.util.concurrent.ExecutorService;

public class GenericOptions implements BeetleOptions {

    public ExecutorService getUtilizedService() {
        return utilizedService;
    }

    private final ExecutorService utilizedService;

    public GenericOptions(ExecutorService utilizedService) {
        this.utilizedService = utilizedService;
    }
}
