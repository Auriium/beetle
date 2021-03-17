package me.aurium.beetle.defaults.command;


import me.aurium.beetle.api.command.*;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class SimpleRegisterer<T> implements CommandRegisterer<T> {

    private final String name;

    private ContextHandler<T> contextHandler;
    private TabContextHandler<T> tabContextHandler;
    private String permission;
    private Collection<String> aliases;
    private String description;
    private String usage;

    public SimpleRegisterer(String commandName) {

        this.name = commandName;
        this.contextHandler = consumed -> {
            throw new NoHandlerException();
        };
        this.tabContextHandler = context -> Collections.emptySet();
        this.aliases = Collections.emptySet();
        this.description = "Default description for minecraft like platforms";
        this.usage = "Default usage for minecraft like platforms";
        this.permission = null;
    }

    public SimpleRegisterer<T> setContextHandler(ContextHandler<T> context) {
        this.contextHandler = context;
        return this;
    }

    public SimpleRegisterer<T> setTabContextHandler(TabContextHandler<T> context) {
        this.tabContextHandler = context;
        return this;
    }

    public SimpleRegisterer<T> setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public SimpleRegisterer<T> setUsage(String usage) {
        this.usage = usage;
        return this;
    }

    public SimpleRegisterer<T> setDescription(String description) {
        this.permission = description;
        return this;
    }

    public SimpleRegisterer<T> setAliases(Collection<String> aliases) {
        this.aliases = aliases;
        return this;
    }

    public SimpleRegisterer<T> setAliases(String... aliases) {
        this.aliases = Arrays.asList(aliases);
        return this;
    }


    @Override
    public void register(CommandRegistry<T> registry) {
        Objects.requireNonNull(contextHandler);
        Objects.requireNonNull(tabContextHandler);
        Objects.requireNonNull(permission);
        Objects.requireNonNull(aliases);
        Objects.requireNonNull(description);
        Objects.requireNonNull(usage);

        Command<T> command = new SimpleCommand<T>(contextHandler,tabContextHandler,name,permission,aliases,description,usage, registry.getContextSource());

        registry.registerCommand(command);
    }

}
