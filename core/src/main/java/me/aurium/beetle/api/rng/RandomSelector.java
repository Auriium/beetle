package me.aurium.beetle.api.rng;

import java.util.Random;

public interface RandomSelector<T> {

    T selectRandom();
    T selectRandom(Random random);

}
