package me.aurium.beetle.defaults.utility.map.multi;

import me.aurium.beetle.defaults.utility.aspect.KeyCloseable;

import java.util.ArrayList;
import java.util.Collection;

public class CloseableOrderedMap<T,V extends KeyCloseable<T>> extends CloseableMultiMap<T,V> {
    @Override
    public void insert(T t, V v) {
        map.computeIfAbsent(t, k -> new ArrayList<>()).add(v);
    }

    @Override
    public void insertAll(T t, Collection<V> v) {
        map.computeIfAbsent(t,k -> new ArrayList<>()).addAll(v);
    }
}
