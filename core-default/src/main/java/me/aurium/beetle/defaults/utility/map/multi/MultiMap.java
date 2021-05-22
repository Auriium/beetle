package me.aurium.beetle.defaults.utility.map.multi;

import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;

public interface MultiMap<T,V> {

    Map<T, Collection<V>> getDelegate();

    Collection<V> get(T key);
    Collection<V> remove(T key);

    void insert(T t, V v);
    void insertAll(T t, Collection<V> v);

    void replaceAll(T t, Collection<V> v);

    void forEach(T key, Consumer<V> consumer);
    void forEvery(Consumer<V> consumer);

}
