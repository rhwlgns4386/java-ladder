package nextstep.ladder.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNonConsecutiveFlagGenerator extends NonConsecutiveFlagGenerator {

    private static final Random RANDOM = new Random();
    private final LadderWidthSize size;

    public RandomNonConsecutiveFlagGenerator(LadderWidthSize size) {
        this.size = size;
    }

    @Override
    protected List<Boolean> createResult() {
        List<Boolean> result = createList();
        for (int i = 0; size.greater(i); i++) {
            result.set(i, random(beforeIsTrue(result, i)));
        }
        return result;
    }

    private List<Boolean> createList() {
        return Stream.generate(() -> false).limit(size.value()).collect(Collectors.toList());
    }

    private boolean beforeIsTrue(List<Boolean> result, int i) {
        return i == 0 || !result.get(i - 1);
    }

    private boolean random(boolean before) {
        if (before) {
            return RANDOM.nextBoolean();
        }

        return false;
    }
}
