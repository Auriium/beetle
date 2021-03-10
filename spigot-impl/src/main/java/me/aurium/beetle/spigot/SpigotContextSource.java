package me.aurium.beetle.spigot;

import me.aurium.beetle.api.command.Context;
import me.aurium.beetle.api.command.ContextSource;
import org.bukkit.command.CommandSender;

public class SpigotContextSource implements ContextSource<CommandSender> {


    @Override
    public Context<CommandSender> context(CommandSender sender, String alias, String[] args) {
        return new SpigotContext(sender, alias, args);
    }
}
