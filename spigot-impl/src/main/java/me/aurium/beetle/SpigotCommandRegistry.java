package me.aurium.beetle;

import me.aurium.beetle.command.AbstractCommand;
import me.aurium.beetle.command.CommandRegistry;
import me.aurium.beetle.command.IllegalCommandMapState;
import me.aurium.beetle.command.SpigotCommandWrapper;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SpigotCommandRegistry implements CommandRegistry<CommandSender> {

    private final CommandMap commandMap;
    private final Set<AbstractCommand<CommandSender>> abstractCommands;

    SpigotCommandRegistry(CommandMap commandMap) {
        this.commandMap = commandMap;
        this.abstractCommands = new HashSet<>();
    }

    @Override
    public void registerCommand(AbstractCommand<CommandSender> abstractCommand) {
        boolean success = commandMap.register(abstractCommand.getName(),new SpigotCommandWrapper(abstractCommand));

        if (!success) throw new IllegalCommandMapState("Tried to register command without success: " + abstractCommand.getName());

        this.abstractCommands.add(abstractCommand);
    }



    @Override
    public void removeCommand(AbstractCommand<CommandSender> abstractCommand) {

    }

    @Override
    public Collection<AbstractCommand<CommandSender>> getAllCommands() {
        return abstractCommands;
    }

    void verifyCommand(AbstractCommand<CommandSender> abstractCommand) {
        assert abstractCommand.getName() != null;
        assert abstractCommand.getAliases() != null;
        assert abstractCommand.getPermission() != null;
    }
}
