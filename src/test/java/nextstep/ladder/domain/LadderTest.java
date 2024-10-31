package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderTest {


    @Test
    public void 입력한높이만큼_라인을_생성한다() {
        List<Boolean> booleans = List.of(true, false);

        NonConsecutiveFlagGeneratorFake fakeGenerator = createFakeGenerator(booleans);
        Ladder ladder = new Ladder(2, fakeGenerator);
        assertThat(ladder).isEqualTo(
                new Ladder(List.of(
                        new Lines(fakeGenerator),
                        new Lines(fakeGenerator))));
    }

    @Test
    public void 라인이_존재하지_않을_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(Collections.emptyList()));
    }

    private static NonConsecutiveFlagGeneratorFake createFakeGenerator(List<Boolean> lines) {
        return new NonConsecutiveFlagGeneratorFake(lines);
    }
}
