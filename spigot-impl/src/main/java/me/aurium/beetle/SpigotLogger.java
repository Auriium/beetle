package me.aurium.beetle;

import me.aurium.beetle.logger.SimpleLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * use SLFLogger, this will be removed soon
 */
public class SpigotLogger implements SimpleLogger {

    private final JavaPlugin plugin;
    private final boolean debug;

    SpigotLogger(JavaPlugin plugin, boolean debug) {
        this.plugin = plugin;
        this.debug = debug;
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
        if (debug) {
            plugin.getLogger().log(Level.INFO,string);
        }
    }

    @Override
    public void info(String string) {
        plugin.getLogger().log(Level.INFO,string);
    }
}
