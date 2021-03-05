package me.aurium.beetle.command;

import me.aurium.beetle.command.CommandData;
import org.bukkit.command.CommandSender;

public class SpigotCommandData implements CommandData {

    private final CommandSender sender;

    public SpigotCommandData(CommandSender sender) {
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
