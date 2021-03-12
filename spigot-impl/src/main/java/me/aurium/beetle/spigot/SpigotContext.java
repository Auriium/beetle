package me.aurium.beetle.spigot;

import me.aurium.beetle.api.command.Context;
import org.bukkit.command.CommandSender;

public class SpigotContext implements Context<CommandSender> {

    private final CommandSender sender;
    private final String alias;
    private final String[] args;

    public SpigotContext(CommandSender sender, String alias, String[] args) {
        this.sender = sender;
        this.alias = alias;
        this.args = args;
    }

    @Override
    public CommandSender getSender() {
        return sender;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public String[] getArgs() {
        return args;
    }

    @Override
    public void debugString(String string) {
        sender.sendMessage(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpigotContext that = (SpigotContext) o;
        return sender.equals(that.sender);
    }

    @Override
    public int hashCode() {
        return sender.hashCode();
    }
}
