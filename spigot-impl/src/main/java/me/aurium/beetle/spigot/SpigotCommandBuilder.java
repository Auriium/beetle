package me.aurium.beetle.spigot;

import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.defaults.command.SimpleCommandBuilder;
import org.bukkit.command.CommandSender;

public class SpigotCommandBuilder extends SimpleCommandBuilder<CommandSender> {

    private static final ContextSource<CommandSender> SOURCE = new SpigotContextSource();

    protected SpigotCommandBuilder(String commandName, ContextSource<CommandSender> source) {
        super(commandName, source);
    }

    public static SpigotCommandBuilder of(String commandName) {
        return new SpigotCommandBuilder(commandName,SOURCE);
    }

    public static SpigotCommandBuilder of(String commandName, ContextSource<CommandSender> source) {
        return new SpigotCommandBuilder(commandName,source);
    }
}
