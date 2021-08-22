import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbsractFindPathInputReader{
    public void readInput() throws Exception {
        Maze maze = getMaze();
        int x = 0;
        int y = 0;
        int startCounter = 0;
        int endCounter = 0;
        Integer previousRow = null;

        List<MazeElement> mazeRow = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String row = input.nextLine();
        while(!row.equals("exit"))
        {
            if(previousRow == null){
                previousRow = row.length();
            }
            if(previousRow != row.length()){
                throw new Exception("Bad dimensions");
            }
            for (char c : row.toCharArray()){
                switch (c){
                    case 'S':
                        if(++startCounter == 1){
                            maze.setStartAxis(new Point(x,y));
                        }else{
                            throw new Exception("Only one start point is allowed");
                        }
                        break;
                    case 'X':
                        if(++endCounter == 1){
                            maze.setEndAxis(new Point(x,y));
                        }else{
                            throw new Exception("Only one end point is allowed");
                        }
                        break;
                    case '.':
                    case '#':
                        break;
                    default:
                        throw new Exception("Bad input. Allowed 'SX.#'");
                }
                mazeRow.add(new MazeElement(c, new Point(x,y)));
                ++x;
            }
            previousRow = row.length();
            maze.getMazeElements().add(new ArrayList<>(mazeRow));
            mazeRow.clear();
            maze.setWidth(x);
            x = 0;
            ++y;
            row = input.nextLine();
        }
        if(startCounter == 0 || endCounter == 0){
            throw new Exception("Couldnt find start or end point");
        }
    }
}
