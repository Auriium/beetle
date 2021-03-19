package me.aurium.beetle.spigot;

import me.aurium.beetle.api.BeetleFactory;
import me.aurium.beetle.defaults.file.CommonFileProvider;
import me.aurium.beetle.defaults.datacore.CommonDatacoreFactory;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.file.FileProvider;
import me.aurium.beetle.defaults.logger.SLFLoggerHelper;
import me.aurium.beetle.api.logger.SimpleLogger;
import me.aurium.beetle.defaults.service.CommonRegistry;
import me.aurium.beetle.api.service.ServiceRegistry;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * A Helper BeetleFactory based around the Spigot API.
 */
public class SpigotBeetleFactory implements BeetleFactory<SpigotBeetle, SpigotOptions> {

    private final JavaPlugin plugin;

    public SpigotBeetleFactory(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Build a new Spigot-Type Beetle from Spigot-Type defaults.
     * @return a new Beetle
     */
    public SpigotBeetle build(SpigotOptions options) {
        //produce dependencies

        Executor platformExecutor = (runnable) -> {
            plugin.getServer().getScheduler().runTaskAsynchronously(plugin,runnable);
        };

        SpigotTasker tasker = new SpigotTasker(platformExecutor, plugin);
        //eventually if PR is ever merged, switch this to getting a executor from the Bukkit caached thread pool

        SimpleLogger logger = SLFLoggerHelper.buildLogger(options.isDebug(), plugin.getName());
        SpigotCommandRegistry commandRegistry = new SpigotCMDHelper(plugin).produceRegistry();
        ServiceRegistry serviceRegistry = new CommonRegistry();
        DataCoreFactory dataCoreFactory = new CommonDatacoreFactory(tasker.getRunner());
        FileProvider fileProvider = new CommonFileProvider(plugin.getDataFolder().toPath());

        return new SpigotBeetle(tasker,logger,dataCoreFactory,serviceRegistry,fileProvider,commandRegistry,options.isDebug());
    }


}