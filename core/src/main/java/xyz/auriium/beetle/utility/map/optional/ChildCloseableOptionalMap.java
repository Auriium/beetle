package xyz.auriium.beetle.utility.map.optional;

import xyz.auriium.beetle.utility.aspect.KeyCloseable;

import java.util.HashMap;
import java.util.Map;


public class ChildCloseableOptionalMap<T,E extends KeyCloseable<T>> extends DelegatingOptionalMap<T,E> implements KeyCloseable<T> {


    @Override
    public void closeSingle(T key) {
        delegate.remove(key).closeSingle(key);
    }

    @Override
    public void close() {
        delegate.values().forEach(KeyCloseable::close);
        delegate.clear();
    }
}
