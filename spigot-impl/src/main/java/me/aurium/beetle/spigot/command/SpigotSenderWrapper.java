package me.aurium.beetle.spigot.command;

import me.aurium.beetle.core.command.CommandData;
import org.bukkit.command.CommandSender;

public class SpigotSenderWrapper implements CommandData {

    private final CommandSender sender;

    public SpigotSenderWrapper(CommandSender sender) {
        this.sender = sender;
    }

    public CommandSender getSender() {
        return sender;
    }

    @Override
    public void debugMessage(String string) {
        sender.sendMessage(string);
    }
}
