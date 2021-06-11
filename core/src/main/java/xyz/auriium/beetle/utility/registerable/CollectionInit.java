package xyz.auriium.beetle.utility.registerable;

import java.util.Collection;

public class CollectionInit<T> {

    private final Collection<T> collection;

    public CollectionInit(Collection<T> collection) {
        this.collection = collection;
    }

    public CollectionInit<T> init(T t) {
        this.collection.add(t);
        return this;
    }

    public Collection<T> delegate() {
        return collection;
    }

}
