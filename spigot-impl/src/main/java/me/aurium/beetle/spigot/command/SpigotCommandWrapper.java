package me.aurium.beetle.spigot.command;

import me.aurium.beetle.core.command.AbstractCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SpigotCommandWrapper extends Command {

    protected final AbstractCommand<SpigotSenderWrapper> command;

    //hacky code in the constructor because the alternative is verbose (lazy)
    public SpigotCommandWrapper(AbstractCommand<SpigotSenderWrapper> abstractCommand) {
        super(abstractCommand.getName(), abstractCommand.getDescription(), abstractCommand.getUsage(), List.copyOf(abstractCommand.getAliases()));

        this.command = abstractCommand;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        return command.execute(new SpigotSenderWrapper(commandSender),strings);
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return List.copyOf(
                command.tabComplete(new SpigotSenderWrapper(sender),args)
        );
    }
}
