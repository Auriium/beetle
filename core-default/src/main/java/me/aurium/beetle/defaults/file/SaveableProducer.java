package me.aurium.beetle.defaults.file;

import me.aurium.beetle.api.file.producer.Producer;

/**
 * Represents a dataholder that can be reloaded
 * @param <T> type of dataholder
 */
public interface SaveableProducer<T> extends Producer {

    T read();
    void save();

}
