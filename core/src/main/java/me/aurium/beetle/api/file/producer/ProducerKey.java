package me.aurium.beetle.api.file.producer;

import java.nio.file.Path;

/**
 * Represents something that can be created on the fly with an identifier in order to act as a sort of key to derive stored dataproducers from
 * @param <T> the type of dataproducer this corresponds to
 * @param <C> the type of options the producer needs to be created
 */
public interface ProducerKey<T extends Producer,C extends ProducerOptions> {

    T newProducer(C options, Path path);

    String getIdentifier();

    boolean isInstance(Producer producer);
}
