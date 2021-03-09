package me.aurium.beetle;

import me.aurium.beetle.api.BeetleFactory;
import me.aurium.beetle.defaults.datacore.CommonDatacoreFactory;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.defaults.file.CommonFileProvider;
import me.aurium.beetle.api.file.FileProvider;
import me.aurium.beetle.defaults.logger.SLFLoggerHelper;
import me.aurium.beetle.api.logger.SimpleLogger;
import me.aurium.beetle.defaults.service.CommonRegistry;
import me.aurium.beetle.api.service.ServiceRegistry;
import me.aurium.beetle.defaults.task.GenericTasker;
import me.aurium.beetle.api.task.Tasker;

import java.nio.file.Path;

public class GenericBeetleFactory implements BeetleFactory<CommonBeetle> {

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
    public CommonBeetle build() {
        Tasker tasker = new GenericTasker();

        tasker.launch();

        SimpleLogger logger = SLFLoggerHelper.buildLogger(isDebug,appName);
        DataCoreFactory factory = new CommonDatacoreFactory(tasker.getRunner());
        ServiceRegistry serviceRegistry = new CommonRegistry();
        FileProvider fileProvider = new CommonFileProvider(baseFolder);

        return new CommonBeetle(tasker,logger,factory,serviceRegistry,fileProvider,isDebug);
    }

}
