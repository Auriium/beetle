package me.aurium.beetle.api.command;

import java.util.Collection;

/**
 * Represents something that can register commands
 * @param <T> The type of data that these commands use
 */
public interface CommandRegistry<T> {

    void registerCommand(Command<T> command);
    void removeCommand(Command<T> command);

    Collection<Command<T>> getAllCommands();

    ContextSource<T> getContextSource();
    CommandBuilder<T> newCommandBuilder(String command);

}
