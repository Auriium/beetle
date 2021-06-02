package me.aurium.beetle.defaults.utility.map.multilink;

import me.aurium.beetle.defaults.utility.aspect.KeyCloseable;

import java.util.Map;

/**
 * i hate explicit gc
 *
 * with that said here is an autistic class
 * @param <K>
 * @param <T>
 * @param <V>
 */
public abstract class AbstractCloseableLinkMap<K,T,V> extends HashLinkMap<K,T,V> implements KeyCloseable<K> {

    @Override
    public void closeSingle(K key) {
        doSingle(map,key);

        map.remove(key);
    }

    protected abstract void doSingle(Map<K,Map<T,V>> handle, K key);
    protected abstract void doClose(Map<K,Map<T,V>> handle);

    @Override
    public void close() {
        doClose(map);

        map.clear();
    }

}
