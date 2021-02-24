package me.aurium.beetle.generic;

import me.aurium.beetle.core.Beetle;
import me.aurium.beetle.core.BeetleFactory;
import me.aurium.beetle.core.DefaultBeetle;
import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.CommonDatacoreFactory;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SLFLoggerHelper;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.registry.SimpleRegistry;
import me.aurium.beetle.core.runner.TaskRunner;
import me.aurium.beetle.core.service.ServiceRegistry;

import java.io.File;

public class GenericBeetleFactory implements BeetleFactory {

    private final Boolean isDebug;
    private final File baseFolder;
    private final String appName;

    /**
     * Create a new generic beetle factory
     * @param baseFolder where file is the FOLDER that is the base
     * @param isDebug whether it is in debug mode or not
     */
    public GenericBeetleFactory(String appName, File baseFolder, boolean isDebug) {
        this.isDebug = isDebug;
        this.baseFolder = baseFolder;
        this.appName = appName;
    }

    @Override
    public Beetle build() {
        SimpleLogger logger = SLFLoggerHelper.buildLogger(isDebug,appName);
        TaskRunner runner = new GenericTaskRunner();

        return build(runner,logger);
    }

    @Override
    public Beetle build(TaskRunner runner) {
        SimpleLogger logger = SLFLoggerHelper.buildLogger(isDebug,appName);

        return build(runner,logger);
    }

    @Override
    public Beetle build(SimpleLogger logger) {
        TaskRunner runner = new GenericTaskRunner();

        return build(runner,logger);
    }

    @Override
    public Beetle build(TaskRunner runner, SimpleLogger logger) {

        DataCoreFactory dataCoreFactory = new CommonDatacoreFactory(runner);
        ServiceRegistry serviceRegistry = new SimpleRegistry();
        FileProvider provider = new GenericFileProvider(baseFolder);


        return new DefaultBeetle(runner,logger,dataCoreFactory,serviceRegistry,provider,isDebug);
    }
}
