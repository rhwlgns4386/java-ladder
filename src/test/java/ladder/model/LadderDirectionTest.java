package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("사다리 방향 테스트")
public class LadderDirectionTest {

    @DisplayName("사다리 방향이 양쪽으로 true면 예외가 발생한다.")
    @Test
    void bothDirectionsExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderDirection(true, true))
                .withMessage("사다리 방향이 양쪽으로 있을 수 없습니다.");
    }

    @DisplayName("첫번째 사다리의 방향에서 왼쪽은 false 이어야 한다.")
    @Test
    void leftOfFirstLadderDirectionTest() {
        // given, when
        LadderDirection firstDirection = LadderDirection.first();

        // then
        assertSame(firstDirection.isLeft(), false);
    }

    @DisplayName("마지막 사다리의 방향에서 오른쪽은 false 이어야 한다.")
    @Test
    void rightOfLastLadderDirectionTest() {
        // given, when
        LadderDirection direction = new LadderDirection(false, true);
        LadderDirection lastDirection = direction.last();

        // then
        assertSame(lastDirection.isRight(), false);
    }

    @DisplayName("오른쪽이 true인 사다리 방향에서 다음 사다리 방향을 구하면, 다음 사다리 방향의 오른쪽은 false 이어야 한다.")
    @Test
    void rightOfNextLadderDirectionTest() {
        // given, when
        LadderDirection ladderDirection = new LadderDirection(false, true);
        LadderDirection nextDirection = ladderDirection.next();

        // then
        assertSame(nextDirection.isRight(), false);
    }
}
