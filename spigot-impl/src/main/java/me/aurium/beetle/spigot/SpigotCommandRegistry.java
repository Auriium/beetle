package me.aurium.beetle.spigot;

import me.aurium.beetle.api.command.*;
import me.aurium.beetle.api.util.NotImplementedException;
import me.aurium.beetle.defaults.command.SimpleRegisterer;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SpigotCommandRegistry implements CommandRegistry<CommandSender> {

    private final CommandMap commandMap;
    private final Set<Command<CommandSender>> commands;
    private final SpigotContextSource contextSource = new SpigotContextSource();

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
        throw new NotImplementedException("Spigot cannot unregister command!");
    }

    @Override
    public void removeCommand(String string) {
        throw new NotImplementedException("Spigot cannot unregister command!");
    }

    @Override
    public void registerBuilder(CommandRegisterer<CommandSender> registerer) {
        registerer.register(this);
    }

    @Override
    public Collection<Command<CommandSender>> getAllCommands() {
        return commands;
    }

    @Override
    public ContextSource<CommandSender> getContextSource() {
        return contextSource;
    }

    void verifyCommand(Command<CommandSender> command) {
        assert command.getName() != null;
        assert command.getAliases() != null;
        assert command.getPermission() != null;
    }
}
