package me.aurium.beetle.spigot;

import me.aurium.beetle.core.exception.IllegalCommandMapState;
import org.apache.commons.lang.reflect.FieldUtils;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class SpigotCMDHelper {

    private final JavaPlugin plugin;

    SpigotCMDHelper(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public SpigotCommandRegistry produceRegistry() {

        CommandMap map = null;

        try {

            PluginManager spm = plugin.getServer().getPluginManager();
            Field field = FieldUtils.getDeclaredField( spm.getClass(), "commandMap", true );
            map = (CommandMap) field.get( spm );

        } catch (IllegalAccessException e) {
            throw new IllegalCommandMapState(e);
        }

        assert map != null : "CommandMap was null at registry build time!";

        return new SpigotCommandRegistry(map);

    }

}
