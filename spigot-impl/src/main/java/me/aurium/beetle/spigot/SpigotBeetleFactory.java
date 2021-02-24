package me.aurium.beetle.spigot;

import me.aurium.beetle.core.Beetle;
import me.aurium.beetle.core.DefaultBeetle;
import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.CommonDatacoreFactory;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SLFLoggerHelper;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.registry.SimpleRegistry;
import me.aurium.beetle.core.runner.TaskRunner;
import me.aurium.beetle.core.service.ServiceRegistry;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A Helper BeetleFactory based around the Spigot API.
 */
public class SpigotBeetleFactory {

    private final JavaPlugin plugin;
    private final boolean isDebug;

    public SpigotBeetleFactory(JavaPlugin plugin, boolean isDebug) {
        this.plugin = plugin;
        this.isDebug = isDebug;
    }

    /**
     * Build a new Spigot-Type Beetle from Spigot-Type defaults.
     * @return a new Beetle
     */
    public Beetle build() {
        //produce dependencies

        SimpleLogger logger = SLFLoggerHelper.buildLogger(isDebug,plugin.getName());
        TaskRunner runner = new SpigotTaskRunner(plugin);


        return build(runner,logger);
    }

    public Beetle build(TaskRunner runner) {
        SimpleLogger logger = SLFLoggerHelper.buildLogger(isDebug,plugin.getName());


        return build(runner,logger);
    }

    public Beetle build(SimpleLogger logger) {
        TaskRunner runner = new SpigotTaskRunner(plugin);


        return build(runner,logger);
    }

    public Beetle build(TaskRunner runner, SimpleLogger logger) {

        SpigotCommandRegistry commandRegistry = new SpigotCMDHelper(plugin).produceRegistry();
        ServiceRegistry serviceRegistry = new SimpleRegistry();
        DataCoreFactory dataCoreFactory = new CommonDatacoreFactory(runner);
        FileProvider fileProvider = new SpigotFileProvider(plugin);

        serviceRegistry.registerService(SpigotCommandRegistry.class,new SpigotCMDHelper(plugin).produceRegistry());

        return new DefaultBeetle(runner,logger,dataCoreFactory,serviceRegistry,fileProvider,isDebug);
    }

}