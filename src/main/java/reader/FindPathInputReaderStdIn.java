package reader;

import maze.Maze;
import maze.MazeElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbsractFindPathInputReader {
    /**
     * Reads and saves maze using standard input. Calls 'verifyMaze()' to find errors in the loaded maze.
     */
    public void readInput() throws Exception {
        Maze maze = getMaze();
        int y = 0;

        List<MazeElement> mazeRow;
        Scanner input = new Scanner(System.in);
        String currentLine = input.nextLine();
        while(!currentLine.equals("exit"))
        {
            mazeRow = setPoints(currentLine, y);
            maze.getMazeElements().add(new ArrayList<>(mazeRow));
            mazeRow.clear();
            ++y;
            currentLine = input.nextLine();
        }
        verifyMaze();
    }
}
