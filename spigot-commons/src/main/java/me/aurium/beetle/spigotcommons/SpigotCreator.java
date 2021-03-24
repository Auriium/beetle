package me.aurium.beetle.spigotcommons;

import me.aurium.beetle.api.file.FileCreator;
import me.aurium.beetle.api.file.producer.CreationOptions;
import me.aurium.beetle.api.file.producer.FileProvisioner;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * for absolute convenience when making files
 */
public class SpigotCreator implements FileCreator {

    private final JavaPlugin plugin;

    public SpigotCreator(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public <T extends FileProvisioner<?, ?>> T createAndLoad(CreationOptions<T> options) {
        return options.newProducer(plugin.getDataFolder().toPath());
    }
}
