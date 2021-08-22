import java.awt.*;

public class MazeElement {
    private Integer type;
    private Point axis;

    public MazeElement(char element, Point axis) {
        this.axis = axis;
        switch (element) {
            case 'S':
                this.type = 3;
                break;
            case 'X':
                this.type = 4;
                break;
            case '.':
                this.type = 0;
                break;
            case '#':
                this.type = 1;
                break;
        }
    }

    public Integer getType() {
        return type;
    }
}
