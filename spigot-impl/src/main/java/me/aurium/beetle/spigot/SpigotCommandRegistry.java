package me.aurium.beetle.spigot;

import me.aurium.beetle.core.command.AbstractCommand;
import me.aurium.beetle.core.command.CommandRegistry;
import me.aurium.beetle.core.exception.IllegalCommandMapState;
import me.aurium.beetle.spigot.command.SpigotCommandWrapper;
import me.aurium.beetle.spigot.command.SpigotCommandData;
import org.bukkit.command.CommandMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SpigotCommandRegistry implements CommandRegistry<SpigotCommandData> {

    private final CommandMap commandMap;
    private final Set<AbstractCommand<SpigotCommandData>> abstractCommands;

    SpigotCommandRegistry(CommandMap commandMap) {
        this.commandMap = commandMap;
        this.abstractCommands = new HashSet<>();
    }

    @Override
    public void registerCommand(AbstractCommand<SpigotCommandData> abstractCommand) {
        boolean success = commandMap.register(abstractCommand.getName(),new SpigotCommandWrapper(abstractCommand));

        if (!success) throw new IllegalCommandMapState("Tried to register command without success: " + abstractCommand.getName());

        this.abstractCommands.add(abstractCommand);
    }



    @Override
    public void removeCommand(AbstractCommand<SpigotCommandData> abstractCommand) {

    }

    @Override
    public Collection<AbstractCommand<SpigotCommandData>> getAllCommands() {
        return abstractCommands;
    }

    void verifyCommand(AbstractCommand<SpigotCommandData> abstractCommand) {
        assert abstractCommand.getName() != null;
        assert abstractCommand.getAliases() != null;
        assert abstractCommand.getPermission() != null;
    }
}
