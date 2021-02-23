package me.aurium.beetle.core.config;

import java.io.File;

public interface FileProducer<T extends DataHolder> {

    T produce(File file);

}
