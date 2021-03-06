package me.aurium.beetle.file.mutableconfig;

import me.aurium.beetle.file.producer.Producer;

import java.nio.file.Path;

public class MutableConfProducer<T> implements Producer {

    private final Class<T> t;
    private final Path path;

    <X> MutableConfProducer(Class<T> t) {
        this.t = t;
        this.path = null;
    }

    public T produce() {
        String string = "s";
        return t.cast(string);
    }

    public Class<T> getProducedType() {
        return t;
    }
}