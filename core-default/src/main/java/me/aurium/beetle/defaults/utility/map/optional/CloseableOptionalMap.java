package me.aurium.beetle.defaults.utility.map.optional;

import me.aurium.beetle.defaults.utility.aspect.KeyCloseable;
import me.aurium.beetle.defaults.utility.map.optional.DelegatingOptionalMap;

import java.util.HashMap;
import java.util.Map;


public class CloseableOptionalMap<T,E extends KeyCloseable<T>> extends DelegatingOptionalMap<T,E> implements KeyCloseable<T> {

    public CloseableOptionalMap(Map<T, E> delegate) {
        super(delegate);
    }

    public CloseableOptionalMap() {
        super(new HashMap<>());
    }

    @Override
    public void closeSingle(T uuid) {
        this.removeIfPresent(uuid,ob -> ob.closeSingle(uuid));
    }

    @Override
    public void close() {
        delegate.forEach((t,e) -> e.close());
        delegate.clear();
    }


}
