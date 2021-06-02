package xyz.auriium.beetle.utility.map.multi;

import xyz.auriium.beetle.utility.aspect.KeyCloseable;

/**
 * A closeable map that can also close it's children (values)
 * @param <T> the key
 * @param <V> the value that is closeable
 */
public class ChildCloseableMultiMap<T,V extends KeyCloseable<T>> extends DelegatingMultiMap<T, V> implements KeyCloseable<T> {
    @Override
    public void closeSingle(T key) {
        map.remove(key).forEach(value -> value.closeSingle(key));
    }

    @Override
    public void close() {
        map.values().forEach(collection -> collection.forEach(KeyCloseable::close));
        map.clear();
    }
}
