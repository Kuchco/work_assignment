import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Maze {
    private List<List<MazeElement>> mazeElements;
    private Point startAxis;
    private int start;
    private Point endAxis;
    private int end;
    private int width;
    private int height;

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

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Point getStartAxis() {
        return startAxis;
    }

    public int getStart() {
        return start;
    }

    public Point getEndAxis() {
        return endAxis;
    }

    public int getEnd() {
        return end;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
