package me.aurium.beetle.core.config;

import java.io.File;
import java.nio.file.Path;

/**
 * Represents something that can provide a file wrapper.
 */
public interface FileProvider {

    /**
     * Creates a dataholder with the path, stemming from a plugin folder / data folder
     * @param producer A file producer
     * @param path the path to the file from the plugin folder
     * @param <T> Type of dataholder
     * @return a dataholder
     */
    <T extends DataHolder> T getDataHolder(FileProducer<T> producer, Path path);

    /**
     * Creates a dataholder with the path based from a string, stemming from a plugin folder / data folder
     * @param producer A file producer
     * @param string the path to the file from the plugin folder
     * @param <T> Type of dataholder
     * @return a dataholder
     */
    <T extends DataHolder> T getDataHolder(FileProducer<T> producer, String string);

    /**
     * Tries to get a dataholder from a direct path
     * @param producer A file producer
     * @param path The direct path to a file
     * @param <T> The type of dataholder
     * @return a dataholder
     */
    <T extends DataHolder> T getDataHolderAbsolute(FileProducer<T> producer, Path path);

    /**
     * Tries to get a dataholder from a string representing a direct path
     * @param producer a file producer
     * @param string the direct path to a file
     * @param <T> type of dataholder
     * @return a dataholder
     */
    <T extends DataHolder> T getDataHolderAbsolute(FileProducer<T> producer, String string);


}
