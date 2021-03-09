package me.aurium.beetle.command;

import java.util.Collection;

/**
 * Represents something that can register commands
 * @param <T> The type of data that these commands use
 */
public interface CommandRegistry<T> {

    void registerCommand(AbstractCommand<T> abstractCommand);
    void removeCommand(AbstractCommand<T> abstractCommand);

    Collection<AbstractCommand<T>> getAllCommands();

}
