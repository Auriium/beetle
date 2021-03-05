package me.aurium.beetle;

import me.aurium.beetle.command.CommandData;
import me.aurium.beetle.command.CommandRegistry;

/**
 * Represents something that can have a commandRegistry produced from it, typically a beetle.
 * @param <T> the type of data the register uses
 */
public interface CommandRegisterable<T extends CommandData> {

    CommandRegistry<T> getCommandRegistry();

}
