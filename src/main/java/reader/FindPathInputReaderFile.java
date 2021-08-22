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
                mazeRow = setPoints(currentLine, y);
            }
            maze.getMazeElements().add(new ArrayList<>(mazeRow));
            mazeRow.clear();
            ++y;
        }
        verifyMaze();
    }
}
