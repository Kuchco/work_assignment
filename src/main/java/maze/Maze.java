package maze;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final List<List<MazeElement>> mazeElements;
    private Point startAxis;
    private Point endAxis;

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

    public Point getStartAxis() {
        return startAxis;
    }

    public Point getEndAxis() {
        return endAxis;
    }
}
