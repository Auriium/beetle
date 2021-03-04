package me.aurium.beetle.spigot;

import me.aurium.beetle.core.BeetleFactory;
import me.aurium.beetle.core.config.CommonFileProvider;
import me.aurium.beetle.core.config.FileProvider;
import me.aurium.beetle.core.datacore.CommonDatacoreFactory;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.logger.SLFLoggerHelper;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.registry.CommonRegistry;
import me.aurium.beetle.core.service.ServiceRegistry;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A Helper BeetleFactory based around the Spigot API.
 */
public class SpigotBeetleFactory implements BeetleFactory<SpigotBeetle> {

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
    public SpigotBeetle build() {
        //produce dependencies
        SpigotTasker tasker = new SpigotTasker(plugin);

        SimpleLogger logger = SLFLoggerHelper.buildLogger(isDebug,plugin.getName());
        SpigotCommandRegistry commandRegistry = new SpigotCMDHelper(plugin).produceRegistry();
        ServiceRegistry serviceRegistry = new CommonRegistry();
        DataCoreFactory dataCoreFactory = new CommonDatacoreFactory(tasker.getRunner());
        FileProvider fileProvider = new CommonFileProvider(plugin.getDataFolder().toPath());

        return new SpigotBeetle(tasker,logger,dataCoreFactory,serviceRegistry,fileProvider,commandRegistry,isDebug);
    }


}