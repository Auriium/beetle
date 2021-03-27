package me.aurium.beetle.spigotcommons;

import me.aurium.beetle.api.file.FileCreator;
import me.aurium.beetle.api.file.producer.CreationOptions;
import me.aurium.beetle.api.file.producer.FileProvisioner;
import me.aurium.beetle.defaults.file.CommonCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Path;

/**
 * for absolute convenience when making files
 */
public class SpigotCreator extends CommonCreator {
    public SpigotCreator(JavaPlugin basePath) {
        super(basePath.getDataFolder().toPath());
    }
}
