package me.aurium.beetle.spigot;

import me.aurium.beetle.api.command.Command;
import me.aurium.beetle.api.command.CommandRegistry;
import me.aurium.beetle.api.command.IllegalCommandMapState;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SpigotCommandRegistry implements CommandRegistry<CommandSender> {

    private final CommandMap commandMap;
    private final Set<Command<CommandSender>> commands;

    SpigotCommandRegistry(CommandMap commandMap) {
        this.commandMap = commandMap;
        this.commands = new HashSet<>();
    }

    @Override
    public void registerCommand(Command<CommandSender> command) {
        boolean success = commandMap.register(command.getName(),new SpigotCommandWrapper(command));

        if (!success) throw new IllegalCommandMapState("Tried to register command without success: " + command.getName());

        this.commands.add(command);
    }



    @Override
    public void removeCommand(Command<CommandSender> command) {

    }

    @Override
    public Collection<Command<CommandSender>> getAllCommands() {
        return commands;
    }

    void verifyCommand(Command<CommandSender> command) {
        assert command.getName() != null;
        assert command.getAliases() != null;
        assert command.getPermission() != null;
    }
}
