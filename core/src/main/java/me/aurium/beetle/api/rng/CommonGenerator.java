package me.aurium.beetle.api.rng;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CommonGenerator<T extends Number> implements RandomGenerator<T> {

    private final T min;
    private final T max;

    public CommonGenerator(T min, T max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public T getRandom() {
        return getRandom(ThreadLocalRandom.current());
    }

    @Override
    public T getRandom(Random random) {
        return random.nextDouble() ;
    }

    @Override
    public Collection<T> getRandom(int amount) {
        List<T> numbers = new ArrayList<>();

        for(int i = 0; i < amount + 1; ++i) numbers.add(getRandom());

        return numbers;
    }
}
