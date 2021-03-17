package me.aurium.beetle.api.initializer;

/**
 * Bullshit fuckcrap that
 * @param <T>
 */
public abstract class AbstractInitialization<T> {

    //ensure noargs constructor
    protected AbstractInitialization() {}

    abstract T initialize();

}
