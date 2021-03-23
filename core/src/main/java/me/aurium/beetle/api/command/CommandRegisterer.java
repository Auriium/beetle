package me.aurium.beetle.api.command;

public interface CommandRegisterer<T> {
    void register(CommandRegistry<T> registry);
}
