package me.aurium.beetle.spigot;

import me.aurium.beetle.core.command.AbstractCommand;
import me.aurium.beetle.core.command.CommandRegistry;
import org.bukkit.command.CommandMap;

public class SpigotCommandRegistry implements CommandRegistry {

    private final CommandMap commandMap;

    SpigotCommandRegistry(CommandMap commandMap) {
        this.commandMap = commandMap;
    }

    @Override
    public void registerCommand(AbstractCommand command) {

    }

    void verifyCommand(AbstractCommand command) {
        assert command.getName() != null;
        assert command.getAliases() != null;
        assert command.getPermission() != null;
    }
}
