package xyz.auriium.beetle.utility.map.optional;

import xyz.auriium.beetle.utility.aspect.KeyCloseable;

public class CloseableOptionalMap<K,V> extends DelegatingOptionalMap<K,V> implements KeyCloseable<K> {
    @Override
    public void closeSingle(K key) {
        delegate.remove(key);
    }

    @Override
    public void close() {
        delegate.clear();
    }
}
