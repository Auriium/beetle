package me.aurium.beetle.api;

public interface BeetleFactory<T extends Beetle, C extends BeetleOptions> {

    T build(C options);

}
