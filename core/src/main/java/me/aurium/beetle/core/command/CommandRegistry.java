package me.aurium.beetle.core.command;

import java.util.Collection;

public interface CommandRegistry<T extends CommandData> {

    void registerCommand(AbstractCommand<T> abstractCommand);
    void removeCommand(AbstractCommand<T> abstractCommand);

    Collection<AbstractCommand<T>> getAllCommands();

}
