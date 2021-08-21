import java.awt.*;

public class QueueElement {
    private Point from;
    private Point to;

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
