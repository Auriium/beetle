package me.aurium.beetle.core.registry;

/**
 * Wrapper for things contained in a ClassRegistry
 * @param <T> thing wrapped
 */
public class Service<T> {

    private final T cached;

    Service(T type) {
        this.cached = type;
    }

    T getService() {
        return this.cached;
    }

}
