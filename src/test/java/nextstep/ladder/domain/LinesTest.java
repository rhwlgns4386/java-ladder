package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.List;
import nextstep.ladder.factory.LinesFactory;
import org.junit.jupiter.api.Test;

public class LinesTest {

    @Test
    public void 사다리_한_줄_생성테스트() {
        List<Boolean> lines = List.of(true, false, true, false);
        assertThat(LinesFactory.lines(lines))
                .isEqualTo(LinesFactory.lines(lines));
    }

    @Test
    public void 사다리는_연속_되면안된다() {
        assertThatIllegalStateException().isThrownBy(() -> LinesFactory.lines(true, true));
    }


    @Test
    public void 사다리의_이동결과를_반환한다() {
        Lines lines = LinesFactory.lines(true, false, true);
        Position positon = new Position(List.of(0, 1, 2, 3));

        lines.move(positon);

        assertThat(positon).isEqualTo(new Position(List.of(1, 0, 3, 2)));
    }

}
