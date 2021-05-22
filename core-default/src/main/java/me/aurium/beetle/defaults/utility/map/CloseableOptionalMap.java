package me.aurium.beetle.defaults.utility.map;

import me.aurium.beetle.defaults.utility.aspect.KeyCloseable;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class CloseableOptionalMap<T,E> extends DelegatingOptionalMap<T,E> implements KeyCloseable<T> {

    public CloseableOptionalMap(Map<T, E> delegate) {
        super(delegate);
    }

    public CloseableOptionalMap() {
        super(new HashMap<>());
    }

    @Override
    public void closeSingle(T uuid) {
        delegate.remove(uuid);
    }

    @Override
    public void close() {
        delegate.clear();
    }


}