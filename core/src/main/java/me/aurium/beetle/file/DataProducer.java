package me.aurium.beetle.file;

import java.io.IOException;

/**
 * Represents something that can produce data from stored data.
 * @param <T> the type of data it can produce from said data
 */
public interface DataProducer<T extends DataHolder> {
    T produce(); //produces the dataHolder from stored file

}
