package xyz.auriium.beetle.utility.map.multilink;

import xyz.auriium.beetle.utility.aspect.KeyCloseable;

public class CloseableLinkMap<K,T,V> extends DelegatingLinkMap<K,T,V> implements KeyCloseable<K> {
    @Override
    public void closeSingle(K key) {
        map.remove(key).clear();
    }

    @Override
    public void close() {
        map.clear();
    }
}
