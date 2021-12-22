package nextstep.ladder.domain.entity;

import java.util.List;
import java.util.stream.Stream;

public class Line {

  private final List<Point> points;

  public Line(List<Point> points) {
    this.points = points;
  }

  public Stream<Point> stream() {
    return points.stream();
  }

  public int size() {
    return points.size();
  }

  public int move(int startingPoint) {
    return points.stream()
                 .filter(point -> point.isSame(startingPoint))
                 .map(Point::move)
                 .findFirst()
                 .orElseThrow(IllegalArgumentException::new);
  }
}