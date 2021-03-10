package me.aurium.beetle.spigot;

import me.aurium.beetle.api.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SpigotCommandWrapper extends org.bukkit.command.Command {

    protected final Command<CommandSender> command;

    //hacky code in the constructor because the alternative is verbose (lazy)
    public SpigotCommandWrapper(Command<CommandSender> command) {
        super(command.getName(), command.getDescription(), command.getUsage(), List.copyOf(command.getAliases()));

        this.command = command;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        return command.execute(commandSender,s,strings);
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return List.copyOf(
                command.tabComplete(sender,alias,args)
        );
    }
}
