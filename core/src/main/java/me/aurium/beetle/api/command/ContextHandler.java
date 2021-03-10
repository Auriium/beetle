package me.aurium.beetle.api.command;

@FunctionalInterface
public interface ContextHandler<T> {

    boolean handle(Context<T> consumed);

}
