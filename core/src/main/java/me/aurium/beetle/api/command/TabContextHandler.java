package me.aurium.beetle.api.command;

import java.util.Collection;

@FunctionalInterface
public interface TabContextHandler<T> {

    Collection<String> handle(Context<T> context);

}
