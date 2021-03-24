package me.aurium.beetle.api.file.data;

import me.aurium.beetle.api.file.producer.FileProvisioner;

import java.nio.file.Path;

public interface StorageProvisioner<T> extends FileProvisioner<T,StorageUnitAccessor<T>> {


}
