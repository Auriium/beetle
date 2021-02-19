package me.aurium.beetle.spigot.command;

import me.aurium.beetle.core.human.Person;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpigotPerson implements Person<CommandSender> {

    private final CommandSender wrapped;

    SpigotPerson(CommandSender player) {
        this.wrapped = player;
    }

    @Override
    public CommandSender getWrapped() {
        return wrapped;
    }

    @Override
    public boolean isActive() {
        return wrapped instanceof Player;
    }


    @Override
    public boolean equals(Person<CommandSender> wrapper) {
        return wrapped.equals(wrapper);
    }

}
