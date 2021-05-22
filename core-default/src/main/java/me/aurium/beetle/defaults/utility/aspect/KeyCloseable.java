package me.aurium.beetle.defaults.utility.aspect;

import java.io.Closeable;
import java.io.IOException;

public interface KeyCloseable<K> extends Closeable {

    void closeSingle(K key);

    @Override
    void close();
}
