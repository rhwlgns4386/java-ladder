package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NotAllDrawTransverseBarStrategy implements TransverseBarStrategy {

    private static final boolean NOT_ALL_DRAW = false;

    @Override
    public List<Boolean> draw(int countOfPerson) {
        return IntStream.range(0, countOfPerson - 1)
                .mapToObj(count -> NOT_ALL_DRAW)
                .collect(Collectors.toList());
    }

}