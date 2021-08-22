import java.awt.Point;

public class QueueElement {
    private final Point from;
    private final Point to;

    public QueueElement(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }
}
