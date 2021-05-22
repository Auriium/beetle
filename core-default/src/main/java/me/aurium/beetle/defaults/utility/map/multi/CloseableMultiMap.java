package me.aurium.beetle.defaults.utility.map.multi;

import me.aurium.beetle.defaults.utility.aspect.KeyCloseable;
import me.aurium.beetle.defaults.utility.aspect.UUIDCloseable;

import java.util.UUID;

public abstract class CloseableMultiMap<T,V extends KeyCloseable<T>> extends DelegatingMultiMap<T,V> implements KeyCloseable<T> {

    @Override
    public void closeSingle(T key) {
        this.forEach(key, closeble -> closeble.closeSingle(key));
        map.remove(key);
    }

    @Override
    public void close() {
        this.forEvery(KeyCloseable::close);
        map.clear();
    }
}
