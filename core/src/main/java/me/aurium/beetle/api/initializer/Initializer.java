package me.aurium.beetle.api.initializer;

/**
 * Bullshit fuckcrap that
 * @param <T>
 */
public interface Initializer<T> {

    T initialize();
    byte priority();

}
