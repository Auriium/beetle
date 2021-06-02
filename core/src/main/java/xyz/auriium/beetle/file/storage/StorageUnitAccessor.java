package xyz.auriium.beetle.file.storage;

import xyz.auriium.beetle.file.ProvisionAccessor;

/**
 * Represents an accessor managed by a FileProvider
 */
public interface StorageUnitAccessor<T> extends ProvisionAccessor {

    void save();

}
