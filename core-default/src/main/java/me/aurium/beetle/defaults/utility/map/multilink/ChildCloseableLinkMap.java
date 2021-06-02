package me.aurium.beetle.defaults.utility.map.multilink;

import me.aurium.beetle.defaults.utility.aspect.KeyCloseable;

import java.util.Map;

public class ChildCloseableLinkMap<K,T,V extends KeyCloseable<K>> extends AbstractCloseableLinkMap<K,T,V> implements KeyCloseable<K> {
    @Override
    public void doSingle(Map<K,Map<T,V>> map, K key) {
        map.get(key).forEach((statekey,state) -> state.closeSingle(key));
    }

    @Override
    public void doClose(Map<K,Map<T,V>> map) {
        map.forEach((uuid,map1) -> map1.forEach((key, state) -> state.close()));
    }
}
