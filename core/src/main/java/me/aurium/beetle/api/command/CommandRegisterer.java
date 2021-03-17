package me.aurium.beetle.api.command;

import java.util.Collection;

public interface CommandRegisterer<T> {
    void register(CommandRegistry<T> registry);


}
