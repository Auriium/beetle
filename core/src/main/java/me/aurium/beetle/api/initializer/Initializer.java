package me.aurium.beetle.api.initializer;

//static hellscape
public interface Initializer {

    <T extends AbstractInitialization<C>,C> C initialize(Class<T> initializer);

}
