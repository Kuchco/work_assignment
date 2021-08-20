import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FindPathInputReaderFile extends AbsractFindPathInputReader{
    public Maze readFile() throws FileNotFoundException {
        Maze maze = getMaze();
        int x = 0;
        int y = 0;
        Vector<MazeElement> mazeRow = new Vector<MazeElement>();
        Scanner input = new Scanner(new File("./src/main/resources/inputMaze.txt"));
        while(input.hasNextLine())
        {
            Scanner row = new Scanner(input.nextLine());
            if(row.hasNext())
            {
                for (char c : row.next().toCharArray()){
                    if(c == 'S'){
                        maze.setStartAxis(new Point(x,y));
                    }
                    else if(c == 'X'){
                        maze.setEndAxis(new Point(x,y));
                    }
                    maze.getMazeElements().add(new MazeElement(c, new Point(x,y)));
                    ++x;
                }
            }
            maze.setWidth(x);
            x = 0;
            ++y;
        }
        maze.setHeight(y);
        maze.setEnd(maze.getWidth() * (maze.getEndAxis().y+1) - (maze.getWidth() - maze.getEndAxis().x));
        maze.setStart(maze.getWidth() * (maze.getStartAxis().y+1) - (maze.getWidth() - maze.getStartAxis().x));
        return maze;
    }
}
