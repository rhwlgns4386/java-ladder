package nextstep.ladder.domain;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.util.ConsecutiveChecker;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        if (ConsecutiveChecker.isConsecutiveLine(lines)) {
            throw new IllegalStateException("연속되는 숫자 입니다");
        }
        this.lines = lines;
    }

    public void move(Position position) {
        for (Line line : lines) {
            line.move(position);
        }
    }

    public List<Boolean> getLines() {
        return lines.stream().map(Line::canMove).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
