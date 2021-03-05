package me.aurium.beetle.file;

/**
 * Represents a dataholder that can be reloaded
 * @param <T> type of dataholder
 */
public interface SaveableProducer<T extends DataHolder> extends DataProducer<T> {

    void save();

}
