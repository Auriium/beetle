package me.aurium.beetle.spigot;

import me.aurium.beetle.core.command.AbstractCommand;
import me.aurium.beetle.core.command.CommandRegistry;
import me.aurium.beetle.core.utility.exception.IllegalCommandMapState;
import me.aurium.beetle.spigot.command.SpigotCommandWrapper;
import me.aurium.beetle.spigot.command.SpigotSenderWrapper;
import org.bukkit.command.CommandMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SpigotCommandRegistry implements CommandRegistry<SpigotSenderWrapper> {

    private final CommandMap commandMap;
    private final Set<AbstractCommand<SpigotSenderWrapper>> abstractCommands;

    SpigotCommandRegistry(CommandMap commandMap) {
        this.commandMap = commandMap;
        this.abstractCommands = new HashSet<>();
    }

    @Override
    public void registerCommand(AbstractCommand<SpigotSenderWrapper> abstractCommand) {
        boolean success = commandMap.register(abstractCommand.getName(),new SpigotCommandWrapper(abstractCommand));

        if (!success) throw new IllegalCommandMapState("Tried to register command without success: " + abstractCommand.getName());

        this.abstractCommands.add(abstractCommand);
    }



    @Override
    public void removeCommand(AbstractCommand<SpigotSenderWrapper> abstractCommand) {

    }

    @Override
    public Collection<AbstractCommand<SpigotSenderWrapper>> getAllCommands() {
        return abstractCommands;
    }

    void verifyCommand(AbstractCommand<SpigotSenderWrapper> abstractCommand) {
        assert abstractCommand.getName() != null;
        assert abstractCommand.getAliases() != null;
        assert abstractCommand.getPermission() != null;
    }
}
