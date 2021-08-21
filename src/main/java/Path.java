import java.awt.*;

public class Path {
    private Point axis;
    private Point previous;

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
