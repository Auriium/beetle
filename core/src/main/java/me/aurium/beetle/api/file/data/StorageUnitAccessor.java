package me.aurium.beetle.api.file.data;

import me.aurium.beetle.api.file.producer.ProvisionAccessor;

import java.nio.file.Path;

/**
 * Represents an accessor managed by a FileProvider
 */
public interface StorageUnitAccessor<T> extends ProvisionAccessor {

    void save();

}
