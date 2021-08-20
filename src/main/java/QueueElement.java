import java.awt.*;

public class QueueElement {
    private int from;
    private int to;
    private int cost;

    public QueueElement(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
