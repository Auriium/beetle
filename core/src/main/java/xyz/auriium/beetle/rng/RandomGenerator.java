package xyz.auriium.beetle.rng;

import java.util.Collection;
import java.util.Random;

public interface RandomGenerator<T extends Number> {

    T getRandom();
    T getRandom(Random random);

    Collection<T> getRandom(int amount);

}
