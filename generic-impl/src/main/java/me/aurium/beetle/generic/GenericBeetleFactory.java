package me.aurium.beetle.generic;

import me.aurium.beetle.core.BeetleFactory;
import me.aurium.beetle.core.DefaultBeetle;
import me.aurium.beetle.core.config.CommonFileProvider;
import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.CommonDatacoreFactory;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SLFLoggerHelper;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.registry.CommonRegistry;
import me.aurium.beetle.core.service.ServiceRegistry;
import me.aurium.beetle.core.task.Tasker;

import java.nio.file.Path;

public class GenericBeetleFactory implements BeetleFactory<DefaultBeetle> {

    private final Boolean isDebug;
    private final Path baseFolder;
    private final String appName;

    /**
     * Create a new generic beetle factory
     * @param baseFolder where file is the FOLDER that is the base
     * @param isDebug whether it is in debug mode or not
     */
    public GenericBeetleFactory(String appName, Path baseFolder, boolean isDebug) {
        this.isDebug = isDebug;
        this.baseFolder = baseFolder;
        this.appName = appName;
    }

    @Override
    public DefaultBeetle build() {
        Tasker tasker = new GenericTasker();

        tasker.launch();

        SimpleLogger logger = SLFLoggerHelper.buildLogger(isDebug,appName);
        DataCoreFactory factory = new CommonDatacoreFactory(tasker.getRunner());
        ServiceRegistry serviceRegistry = new CommonRegistry();
        FileProvider fileProvider = new CommonFileProvider(baseFolder);

        return new DefaultBeetle(tasker,logger,factory,serviceRegistry,fileProvider,isDebug);
    }

}
