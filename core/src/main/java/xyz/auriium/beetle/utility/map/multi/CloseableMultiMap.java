package xyz.auriium.beetle.utility.map.multi;

import xyz.auriium.beetle.utility.aspect.KeyCloseable;

public class CloseableMultiMap<T,V> extends DelegatingMultiMap<T, V> implements KeyCloseable<T> {

    @Override
    public void closeSingle(T key) {
        map.remove(key);
    }

    @Override
    public void close() {
        map.clear();
    }
}
