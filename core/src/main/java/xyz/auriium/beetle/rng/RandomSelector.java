package xyz.auriium.beetle.rng;

import java.util.Random;

public interface RandomSelector<T> {

    T selectRandom();
    T selectRandom(Random random);

}
