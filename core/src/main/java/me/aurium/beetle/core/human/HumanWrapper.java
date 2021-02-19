package me.aurium.beetle.core.human;

/**
 * Marker interface class for human-like command senders.
 */
public interface HumanWrapper<T> {

    T getWrapped();

    boolean isConsole();
    boolean equals(HumanWrapper<T> wrapper);

}
