package me.aurium.beetle.api.command;

import java.util.Collection;

public interface CommandBuilder<T> {

    CommandBuilder<T> setContextHandler(ContextHandler<T> context);
    CommandBuilder<T> setTabContextHandler(TabContextHandler<T> context);
    CommandBuilder<T> setPermission(String permission);
    CommandBuilder<T> setUsage(String usage);
    CommandBuilder<T> setDescription(String description);
    CommandBuilder<T> setAliases(Collection<String> aliases);
    CommandBuilder<T> setAliases(String... aliases);

    Command<T> build();
    void register();


}
