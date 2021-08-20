import java.awt.*;

public class PathAndCost {
    private int axis;
    private int previous;
    private int cost;

    public PathAndCost(int axis, int previous, int cost) {
        this.axis = axis;
        this.previous = previous;
        this.cost = cost;
    }

    public int getAxis() {
        return axis;
    }

    public int getPrevious() {
        return previous;
    }
}
