package me.aurium.beetle.core;

import me.aurium.beetle.core.command.CommandData;
import me.aurium.beetle.core.command.CommandRegistry;

/**
 * Represents something that can have a commandRegistry produced from it, typically a beetle.
 * @param <T> the type of data the register uses
 */
public interface CommandRegisterable<T extends CommandData> {

    CommandRegistry<T> getCommandRegistry();

}
