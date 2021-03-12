package me.aurium.beetle.api.command;

public interface ContextSource<T> {

    Context<T> context(T sender, String alias, String[] args);

}
