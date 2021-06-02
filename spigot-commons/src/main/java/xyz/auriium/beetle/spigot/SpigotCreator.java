package xyz.auriium.beetle.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.auriium.beetle.file.CommonCreator;

/**
 * for absolute convenience when making files
 */
public class SpigotCreator extends CommonCreator {
    public SpigotCreator(JavaPlugin basePath) {
        super(basePath.getDataFolder().toPath());
    }
}
