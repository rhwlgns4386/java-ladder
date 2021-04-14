package nextstep.ladder;

import nextstep.model.Line;
import nextstep.model.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("라인마킹테스트")
    void mark() {
        int countOfPerson = 3;
        Line line = new Line(countOfPerson);
        line.markOne(2);
        assertThat(line.getPoints()).isEqualTo(new Points(Arrays.asList(false, false, true)));
    }

    @Test
    @DisplayName("라인그리기테스트")
    void draw() {
        int countOfPerson = 3;
        Line line = new Line(countOfPerson);
        line.markOne(2);
        assertThat(line.lineString()).isEqualTo("|     |     |-----|");
    }
}