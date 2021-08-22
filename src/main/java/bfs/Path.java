package bfs;

import java.awt.Point;

public class Path {
    private final Point axis;
    private final Point previous;

    public Path(Point axis, Point previous) {
        this.axis = axis;
        this.previous = previous;
    }

    public Point getAxis() {
        return axis;
    }

    public Point getPrevious() {
        return previous;
    }
}
