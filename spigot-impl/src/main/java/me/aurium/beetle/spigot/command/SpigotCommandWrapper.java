package me.aurium.beetle.spigot.command;

import me.aurium.beetle.core.command.AbstractCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SpigotCommandWrapper extends Command {

    protected final AbstractCommand command;

    //hacky code in the constructor because the alternative is verbose (lazy)
    SpigotCommandWrapper(AbstractCommand command) {
        super(command.getName(), command.getDescription(), command.getUsage(), List.copyOf(command.getAliases()));

        this.command = command;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        return command.execute(new SpigotPerson(commandSender),strings);
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return List.copyOf(
                command.tabComplete(new SpigotPerson(sender),args)
        );
    }
}
