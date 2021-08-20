import java.awt.*;

public class MazeElement {
    private Integer type;
    private Point axis;

    public MazeElement(char element, Point axis) {
        this.axis = axis;
        switch (element) {
            case 'S' -> this.type = 3;
            case 'X' -> this.type = 4;
            case '.' -> this.type = 0;
            case '#' -> this.type = 1;
        }
    }

    public MazeElement() {
        this.type = -1;
        this.axis = new Point();
    }

    public void add(String element){
        switch (element) {
            case "S" -> this.type = 3;
            case "X" -> this.type = 4;
            case "." -> this.type = 0;
            case "#" -> this.type = 1;
        }
    }

    public Integer getType() {
        return type;
    }
}
