package me.aurium.beetle.api;

import me.aurium.beetle.api.command.CommandRegistry;
import me.aurium.beetle.api.command.ContextSource;

/**
 * Represents something that can have a commandRegistry produced from it, typically a beetle.
 * @param <T> the type of data the register uses
 */
public interface CommandRegisterable<T> {

    CommandRegistry<T> getCommandRegistry();

}
