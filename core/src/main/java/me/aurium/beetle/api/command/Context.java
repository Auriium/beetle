package me.aurium.beetle.api.command;

public interface Context<T> {

    T getSender();

    String getAlias();
    String[] getArgs();

    void debug(String string); //sends a debug message...


}
