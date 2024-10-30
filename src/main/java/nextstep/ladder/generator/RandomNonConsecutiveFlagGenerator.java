package nextstep.ladder.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNonConsecutiveFlagGenerator extends NonConsecutiveFlagGenerator {

    private final int size;

    public RandomNonConsecutiveFlagGenerator(int size) {
        this.size = size;
    }

    @Override
    protected List<Boolean> createResult() {
        List<Boolean> result = createList();
        for (int i = 0; i < size; i++) {
            result.set(i, random(beforeIsTrue(result, i)));
        }
        return result;
    }

    private List<Boolean> createList() {
        return Stream.generate(() -> false).limit(size).collect(Collectors.toList());
    }

    private boolean beforeIsTrue(List<Boolean> result, int i) {
        return !result.get(i - 1) || i == 0;
    }

    private boolean random(boolean before) {
        if (before) {
            return false;
        }

        Random random = new Random();
        return random.nextBoolean();
    }
}
