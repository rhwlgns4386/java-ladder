package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final static int FIRST_POINT_COUNT = 1;
    private final static int LAST_POINT_COUNT = 1;
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(int playersCount) {
        this.points = init(playersCount);
    }

    private List<Point> init(int playersCount) {
        List<Point> points = new ArrayList<>();

        PointGenerator pointGenerator = new PointGenerator(points);
        Point point = pointGenerator.first();
        Point lastBodyPoint = pointGenerator.body(bodyCount(playersCount), point);
        pointGenerator.last(lastBodyPoint);

        return points;
    }

    private int bodyCount(int playersCount) {
        return playersCount - (FIRST_POINT_COUNT + LAST_POINT_COUNT);
    }

    public int move(int positionIndex) {
        return points.get(positionIndex).move();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}