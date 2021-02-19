package me.aurium.beetle.spigot;

import me.aurium.beetle.core.Beetle;
import me.aurium.beetle.core.logger.SLFLoggerHelper;
import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.runner.TaskRunner;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A Helper BeetleFactory based around the Spigot API.
 */
public class SpigotBeetleFactory {

    private final JavaPlugin plugin;

    public SpigotBeetleFactory(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Build a new Spigot-Type Beetle from Spigot-Type defaults.
     * @return a new Beetle
     */
    public Beetle build() {
        //produce dependencies

        SimpleLogger logger = new SLFLoggerHelper().buildLogger();
        TaskRunner runner = new SpigotTaskRunner(plugin);


        return null;
    }

    public Beetle build(TaskRunner runner) {
        SimpleLogger logger = new SLFLoggerHelper().buildLogger();


        return null;
    }

    public Beetle build(SimpleLogger logger) {
        TaskRunner runner = new SpigotTaskRunner(plugin);


        return null;
    }

    public Beetle build(TaskRunner runner, SimpleLogger logger) {

        SpigotCommandRegistry commandRegistry = new SpigotCMDHelper(plugin).produceRegistry();

        return null;
    }

}