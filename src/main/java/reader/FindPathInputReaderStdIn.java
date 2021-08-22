package reader;

import maze.Maze;
import maze.MazeElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbsractFindPathInputReader {
    public void readInput() throws Exception {
        Maze maze = getMaze();
        int x = 0;
        int y = 0;

        List<MazeElement> mazeRow = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String currentLine = input.nextLine();
        while(!currentLine.equals("exit"))
        {
            for (char c : currentLine.toCharArray()){
                switch (c){
                    case 'S':
                        maze.setStartAxis(new Point(x,y));
                        break;
                    case 'X':
                        maze.setEndAxis(new Point(x,y));
                        break;
                    default:
                        break;
                }
                mazeRow.add(new MazeElement(c));
                ++x;
            }
            maze.getMazeElements().add(new ArrayList<>(mazeRow));
            mazeRow.clear();
            x = 0;
            ++y;
            currentLine = input.nextLine();
        }
        verifyMaze();
    }
}
