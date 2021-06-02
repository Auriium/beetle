package xyz.auriium.beetle.rng;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class IntGenerator implements RandomGenerator<Integer> {

    private final Integer min;
    private final Integer max;

    public IntGenerator(Integer min, Integer max) {
        Objects.requireNonNull(max);
        Objects.requireNonNull(min);

        this.min = min;
        this.max = max;
    }

    @Override
    public Integer getRandom() {
        return getRandom(ThreadLocalRandom.current());
    }

    @Override
    public Integer getRandom(Random random) {
        return min + (max - min) * random.nextInt();
    }

    @Override
    public Collection<Integer> getRandom(int amount) {
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < amount + 1; ++i) numbers.add(getRandom());

        return numbers;
    }
}
