package me.aurium.beetle.defaults.utility.map.multilink;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HashLinkMap<K,T,V> implements MultiLinkMap<K,T,V> {

    protected final Map<K,Map<T,V>> map = new HashMap<>();

    @Override
    public Map<K, Map<T, V>> delegate() {
        return map;
    }

    @Override
    public Optional<V> getByKey(K key, T key2) {
        return Optional.ofNullable(map.computeIfAbsent(key, s -> new HashMap<>()).get(key2));
    }

    @Override
    public V insert(K key, T key2, V value) {
        map.computeIfAbsent(key, s -> new HashMap<>()).computeIfAbsent(key2, s -> value);

        return value;
    }
}
