package me.aurium.beetle;

public interface BeetleFactory<T extends Beetle> {

    T build();

}
