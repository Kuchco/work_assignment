import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbsractFindPathInputReader{
    public Maze readInput() {
        Maze maze = getMaze();
        int x = 0;
        int y = 0;

        List<MazeElement> mazeRow = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String row = "";
        row = input.nextLine();
        while(!row.equals("exit"))
        {
            for (char c : row.toCharArray()){
                if(c == 'S'){
                    maze.setStartAxis(new Point(x,y));
                }
                else if(c == 'X'){
                    maze.setEndAxis(new Point(x,y));
                }
                mazeRow.add(new MazeElement(c, new Point(x,y)));
                ++x;
            }
            maze.getMazeElements().add(new ArrayList<>(mazeRow));
            mazeRow.clear();
            maze.setWidth(x);
            x = 0;
            ++y;
            row = input.nextLine();
        }
        maze.setHeight(y);
        maze.setEnd(maze.getWidth() * (maze.getEndAxis().y+1) - (maze.getWidth() - maze.getEndAxis().x));
        maze.setStart(maze.getWidth() * (maze.getStartAxis().y+1) - (maze.getWidth() - maze.getStartAxis().x));
        return maze;
    }
}
