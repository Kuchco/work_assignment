import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<List<MazeElement>> mazeElements;
    private Point startAxis;
    private Point endAxis;
    private int width;

    public Maze() {
        this.mazeElements = new ArrayList<>();
    }

    public List<List<MazeElement>> getMazeElements() {
        return mazeElements;
    }

    public void setStartAxis(Point startAxis) {
        this.startAxis = startAxis;
    }

    public void setEndAxis(Point endAxis) {
        this.endAxis = endAxis;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getStartAxis() {
        return startAxis;
    }

    public Point getEndAxis() {
        return endAxis;
    }
}
