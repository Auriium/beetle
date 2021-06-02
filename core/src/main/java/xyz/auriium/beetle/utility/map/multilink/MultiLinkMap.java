package xyz.auriium.beetle.utility.map.multilink;

import java.util.Map;
import java.util.Optional;

public interface MultiLinkMap<K,T,V> {

    Map<K, Map<T,V>> delegate();

    Optional<V> getByKey(K key, T key2);
    V insert(K key, T key2, V value);

    int size();

}
