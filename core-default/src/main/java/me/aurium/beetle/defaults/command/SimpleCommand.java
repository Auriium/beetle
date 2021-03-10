package me.aurium.beetle.defaults.command;

import me.aurium.beetle.api.command.Command;
import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.api.command.TabContextHandler;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Represents a command as an object. It is better to use this class than manually implement command
 * (composition, not inheritance)
 * @param <T> the type of sender
 */
public class SimpleCommand<T> implements Command<T> {

    private final ContextHandler<T> contextHandler;
    private final TabContextHandler<T> tabContextHandler;
    private final String name;
    private final String permission;
    private final Collection<String> aliases;
    private final String description;
    private final String usage;
    private final ContextSource<T> source;


    public SimpleCommand(ContextHandler<T> contextHandler, TabContextHandler<T> tabContextHandler, String name, String permission, Collection<String> aliases, String description, String usage, ContextSource<T> contextSource) {
        this.contextHandler = contextHandler;
        this.tabContextHandler = tabContextHandler;
        this.name = name;
        this.permission = permission;
        this.aliases = aliases;
        this.description = description;
        this.usage = usage;
        this.source = contextSource;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPermission() {
        return permission;
    }

    @Override
    public boolean execute(T sender, String alias, String[] args) {
        return contextHandler.handle(source.context(sender, alias, args));
    }

    @Override
    public Collection<String> tabComplete(T sender, String alias, String[] args) {
        return tabContextHandler.handle(source.context(sender, alias, args));
    }

    @Override
    public Collection<String> getAliases() {
        return aliases;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getUsage() {
        return usage;
    }

}
