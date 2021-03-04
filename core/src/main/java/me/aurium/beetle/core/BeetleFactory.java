package me.aurium.beetle.core;

public interface BeetleFactory<T extends Beetle> {

    T build();

}
