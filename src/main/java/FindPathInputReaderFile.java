import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderFile extends AbsractFindPathInputReader{
    public void readFile(String filePath) throws Exception {
        Maze maze = getMaze();
        int x = 0;
        int y = 0;
        int startCounter = 0;
        int endCounter = 0;
        String nextRow = "";
        Integer previousRow = null;

        List<MazeElement> mazeRow = new ArrayList<>();
        Scanner input = new Scanner(new File(filePath));
        while(input.hasNextLine())
        {
            Scanner row = new Scanner(input.nextLine());
            if(row.hasNext())
            {
                nextRow = row.next();
                if(previousRow == null){
                    previousRow = nextRow.length();
                }
                if(previousRow != nextRow.length()){
                    throw new Exception("Bad dimensions");
                }
                for (char c : nextRow.toCharArray()){
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
            }
            previousRow = nextRow.length();
            maze.getMazeElements().add(new ArrayList<>(mazeRow));
            mazeRow.clear();
            maze.setWidth(x);
            x = 0;
            ++y;
        }
        if(startCounter == 0 || endCounter == 0){
            throw new Exception("Couldnt find start or end point");
        }
    }
}
