package me.aurium.beetle.core.command;

/**
 * Represents something that can have commands registered to it.
 *
 */
public interface CommandRegistry {

    void registerCommand(AbstractCommand command);


}
