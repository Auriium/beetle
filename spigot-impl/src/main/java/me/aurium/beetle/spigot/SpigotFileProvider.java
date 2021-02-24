package me.aurium.beetle.spigot;

import me.aurium.beetle.core.config.DataHolder;
import me.aurium.beetle.core.config.FileProducer;
import me.aurium.beetle.core.config.SimpleFileProvider;
import me.aurium.beetle.core.utility.exception.UncheckedIOException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class SpigotFileProvider extends SimpleFileProvider {

    private final JavaPlugin plugin;

    SpigotFileProvider(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public <T extends DataHolder> T getDataHolder(FileProducer<T> producer, Path path) {
        File sub = plugin.getDataFolder().toPath().resolve(path).toFile();

        try {
            return producer.produce(sub);
        } catch(IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    @Override
    public <T extends DataHolder> T getDataHolder(FileProducer<T> producer, String string) {
        File sub = new File(plugin.getDataFolder(),string);

        try {
            return producer.produce(sub);
        } catch(IOException e) {
            throw new UncheckedIOException(e);
        }

    }
}
