package me.aurium.beetle.file;

import me.aurium.beetle.file.producer.Producer;
import me.aurium.beetle.file.producer.ProducerKey;
import me.aurium.beetle.file.producer.ProducerOptions;

import java.nio.file.Path;

/**
 * Represents something that can get a custom producer from a key, or have a key registered alongside it's options
 */
public interface FileProvider {

    /**
     * Register a new producer with corresponding options into the provider
     * @param producer the key. Recommended to use the key's static identifier method if it exists or instantiate one if it does not.
     * @param options the options
     * @param path the path to the file that should be registered
     * @param <T> the type of options that are required
     * @throws ProducerAlreadyRegisteredException if the producer is already registered
     */
    <T extends ProducerOptions> void registerNewFileProducer(ProducerKey<?,T> producer, T options, Path path);

    /**
     * Register a new producer with corresponding options into the provider
     * @param producer the key. Recommended to use the key's static identifier method if it exists or instantiate one if it does not.
     * @param options the options
     * @param path the path to the file that should be registered
     * @param <T> the type of options that are required
     * @throws ProducerAlreadyRegisteredException if the producer is already registered
     */
    <T extends ProducerOptions> void registerNewFileProducer(ProducerKey<?,T> producer, T options, String path);

    /**
     * Register a new producer with corresponding options into the provider using the home path
     * @param producer the key. Recommended to use the key's static identifier method if it exists or instantiate one if it does not.
     * @param options the options
     * @param <T> the type of options that are required
     * @throws ProducerAlreadyRegisteredException if the producer is already registered
     */
    <T extends ProducerOptions> void registerNewFileProducer(ProducerKey<?,T> producer, T options);

    /**
     * Gets the producer corresponding to a key if possible
     * @param key the key
     * @param <T> the corresponding producer
     * @return the producer if possible
     * @throws NonexistentProducerException if there is no producer under that key
     * @throws ProducerAlreadyRegisteredException if another producer already exists under that key's identifier
     */
    <T extends Producer> T getProducer(ProducerKey<T,?> key);

}
