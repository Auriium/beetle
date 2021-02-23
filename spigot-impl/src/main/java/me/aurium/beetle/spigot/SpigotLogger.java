package me.aurium.beetle.spigot;

import me.aurium.beetle.core.logger.SimpleLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * use SLFLogger
 */
public class SpigotLogger implements SimpleLogger {

    private final JavaPlugin plugin;

    public SpigotLogger(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void error(String string) {
        plugin.getLogger().log(Level.SEVERE,string);
    }

    @Override
    public void warn(String string) {
        plugin.getLogger().log(Level.WARNING,string);
    }

    @Override
    public void debug(String string) {
        plugin.getLogger().log(Level.INFO,string);
    }

    @Override
    public void info(String string) {
        plugin.getLogger().log(Level.INFO,string);
    }
}