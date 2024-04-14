package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class ColumnIndex {
    private static final int MIN = 0;

    private final int value;

    public ColumnIndex(int value) {
        assertPositive(value);

        this.value = value;
    }

    private void assertPositive(int value) {
        if (value < MIN) {
            throw new IllegalArgumentException("열 번호는 0이상이어야 합니다.");
        }
    }

    public int value() {
        return this.value;
    }

    public ColumnIndex move(int value) {
        return new ColumnIndex(Math.max(MIN, this.value + value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnIndex that = (ColumnIndex) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}