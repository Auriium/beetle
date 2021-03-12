package me.aurium.beetle.api.command;

public interface Context<T> {

    T getSender();
    String getAlias();
    String[] getArgs();

    void debugString(String string);
    boolean equals(Object object);

}
