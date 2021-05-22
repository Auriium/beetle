package me.aurium.beetle.api.initializer;

import java.util.ServiceLoader;

//hell

/**
 * Literally do not use this
 */
public class StaticInitializeLoader implements InitializeLoader {


    @Override
    public <T extends Initializer<C>, C> C initialize(Class<T> initializer) {

        ServiceLoader<T> loader = ServiceLoader.load(initializer,initializer.getClassLoader());

        return null;
    }
}
