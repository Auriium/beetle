package me.aurium.beetle.api.rng;

import java.util.Collection;
import java.util.Random;

public interface RandomGenerator<T extends Number> {

    T getRandom();
    T getRandom(Random random);

    Collection<T> getRandom(int amount);

}
