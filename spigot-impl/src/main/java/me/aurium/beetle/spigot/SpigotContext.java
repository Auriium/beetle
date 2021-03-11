package me.aurium.beetle.spigot;

import me.aurium.beetle.defaults.command.AbstractContext;
import org.bukkit.command.CommandSender;

public class SpigotContext extends AbstractContext<CommandSender> {

    protected SpigotContext(CommandSender sender, String alias, String[] args) {
        super(sender, alias, args);
    }

    public void debug(String string) {
        getSender().sendMessage(string);
    }

}
