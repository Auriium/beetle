package me.aurium.beetle.api.initializer;

//static hellscape
public interface InitializeLoader {

    <T extends Initializer<C>,C> C initialize(Class<T> initializer);

}
