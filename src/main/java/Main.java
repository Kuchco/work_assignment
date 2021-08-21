import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile();
        Maze maze;
        try {
            maze = findPathInputReaderFile.readFile("./src/main/resources/inputMaze.txt");
        }catch (FileNotFoundException fnfe) {
            System.out.println("File was not found");
        }
        List<Point> shortestPath =  findPathInputReaderFile.findShortestPath();
    }
}
