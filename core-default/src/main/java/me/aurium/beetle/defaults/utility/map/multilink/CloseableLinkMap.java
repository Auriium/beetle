package me.aurium.beetle.defaults.utility.map.multilink;

import me.aurium.beetle.defaults.utility.aspect.KeyCloseable;

public class CloseableLinkMap<K,T,V extends KeyCloseable<K>> extends HashLinkMap<K,T,V> implements KeyCloseable<K> {
    @Override
    public void closeSingle(K key) {
        map.get(key).forEach((stateKey, state) -> state.closeSingle(key));
    }

    @Override
    public void close() {
        map.forEach((uuid,map1) -> map1.forEach((key, state) -> state.close()));
    }
}
