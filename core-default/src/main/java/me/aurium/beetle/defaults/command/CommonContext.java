package me.aurium.beetle.defaults.command;

import me.aurium.beetle.api.command.Context;

public class CommonContext<T> implements Context<T> {

    private final T sender;
    private final String alias;
    private final String[] args;

    public CommonContext(T sender, String alias, String[] args) {
        this.sender = sender;
        this.alias = alias;
        this.args = args;
    }

    @Override
    public T getSender() {
        return sender;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public String[] getArgs() {
        return args;
    }
}
