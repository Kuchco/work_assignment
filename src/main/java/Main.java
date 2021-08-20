import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FindPathInputReaderFile lol = new FindPathInputReaderFile();
        Maze maze;
        try {
            maze = lol.readFile();

        }catch (FileNotFoundException fnfe) {
            System.out.println("fok");
        }

        lol.findShortestPath();
        List<Integer> shortestPath =  lol.getShortestPath();
    }
}
