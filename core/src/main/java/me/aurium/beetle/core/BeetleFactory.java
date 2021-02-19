package me.aurium.beetle.core;

public interface BeetleFactory<B extends Beetle> {

    B build();

}
