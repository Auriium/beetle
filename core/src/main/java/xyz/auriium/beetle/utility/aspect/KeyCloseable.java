package xyz.auriium.beetle.utility.aspect;

import java.io.Closeable;
import java.io.IOException;

public interface KeyCloseable<K> extends Closeable {

    void closeSingle(K key);

    @Override
    void close();
}
