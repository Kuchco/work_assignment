package reader;

import maze.Maze;
import maze.MazeElement;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderFile extends AbsractFindPathInputReader {
    /**
     * Reads and saves maze from file at 'filePath'. Calls 'verifyMaze()' to find errors in the loaded maze.
     */
    public void readFile(String filePath) throws Exception {
        Maze maze = getMaze();
        int x = 0;
        int y = 0;
        String currentLine;

        List<MazeElement> mazeRow = new ArrayList<>();
        Scanner input = new Scanner(new File(filePath));
        while(input.hasNextLine())
        {
            Scanner row = new Scanner(input.nextLine());
            if(row.hasNext())
            {
                currentLine = row.next();
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
            }
            maze.getMazeElements().add(new ArrayList<>(mazeRow));
            mazeRow.clear();
            x = 0;
            ++y;
        }
        verifyMaze();
    }
}
