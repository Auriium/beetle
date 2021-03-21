package me.aurium.beetle.api.capability;

import me.aurium.beetle.api.command.CommandRegistry;

/**
 * Represents something that can have a commandRegistry produced from it, typically a beetle.
 * @param <T> the type of data the register uses
 */
public interface CommandRegisterable<T> {

    CommandRegistry<T> getCommandRegistry();

}
