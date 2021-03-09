package me.aurium.beetle.api;

public interface BeetleFactory<T extends Beetle> {

    T build();

}
