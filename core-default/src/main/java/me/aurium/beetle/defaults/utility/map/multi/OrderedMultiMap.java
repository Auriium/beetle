package me.aurium.beetle.defaults.utility.map.multi;

import java.util.ArrayList;
import java.util.Collection;

public class OrderedMultiMap<T,V> extends DelegatingMultiMap<T,V> {

    @Override
    public void insert(T t, V v) {
        map.computeIfAbsent(t, k -> new ArrayList<>()).add(v);
    }

    @Override
    public void insertAll(T t, Collection<V> v) {
        map.computeIfAbsent(t,k -> new ArrayList<>()).addAll(v);
    }

}
