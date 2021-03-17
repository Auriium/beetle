package me.aurium.beetle.api.initializer;

import java.util.HashMap;
import java.util.Map;

//hell

/**
 * Literally do not use this
 */
public class StaticInitializer {

    private static final Map<AbstractInitialization<?>,?> map = new HashMap<>();


    public static <T extends AbstractInitialization<C>,C> C initialize(Class<T> initializer) {
        return null;
    }

}
