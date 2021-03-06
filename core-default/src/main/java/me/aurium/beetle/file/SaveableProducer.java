package me.aurium.beetle.file;

import me.aurium.beetle.file.producer.Producer;

/**
 * Represents a dataholder that can be reloaded
 * @param <T> type of dataholder
 */
public interface SaveableProducer<T> extends Producer {

    T read();
    void save();

}
