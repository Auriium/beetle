package me.aurium.beetle.defaults.utility.map.multilink;

import java.util.Map;

public class CloseableLinkMap<K,T,V> extends AbstractCloseableLinkMap<K,T,V> {

    @Override
    protected void doSingle(Map<K, Map<T, V>> handle, K key) {

    }

    @Override
    protected void doClose(Map<K, Map<T, V>> handle) {

    }
}
