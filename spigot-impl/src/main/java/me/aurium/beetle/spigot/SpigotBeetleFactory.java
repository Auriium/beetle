package me.aurium.beetle.spigot;

import me.aurium.beetle.core.BeetleFactory;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotBeetleFactory implements BeetleFactory<SpigotBeetle> {

    private final JavaPlugin plugin;

    public SpigotBeetleFactory(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Build a new SpigotBeetle using defaults
     * @return a new SpigotBeetle
     */
    @Override
    public SpigotBeetle build() {
        SpigotTaskRunner taskRunner = new SpigotTaskRunner(plugin);



        return null;
    }

}