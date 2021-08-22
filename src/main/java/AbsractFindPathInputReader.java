import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbsractFindPathInputReader {
    private Maze maze = new Maze();
    private LinkedList<QueueElement> queue = new LinkedList<>();
    private List<Path> paths = new ArrayList<>();

    public Path findExistingPath(Point element){
        for(Path path : paths){
            if(path.getAxis().x == element.x && path.getAxis().y == element.y){
                return path;
            }
        }
        return null;
    }

    public String getShortestPath() throws Exception {
        List<Path> shortestPath = new ArrayList<>();
        char[] directions;
        int index = 0;
        Path path = findExistingPath(maze.getEndAxis());

        if(path == null){
            throw new Exception("Couldnt find a path");
        }
        while(path.getAxis() != maze.getStartAxis()){
            shortestPath.add(path);
            path = findExistingPath(path.getPrevious());
        }
        Collections.reverse(shortestPath);
        directions = new char[shortestPath.size()];

        for(Path finalPath : shortestPath){
            if(finalPath.getPrevious().x < finalPath.getAxis().x){
                directions[index++] = 'r';
            }else if(finalPath.getPrevious().x > finalPath.getAxis().x){
                directions[index++] = 'l';
            }else if(finalPath.getPrevious().y < finalPath.getAxis().y){
                directions[index++] = 'd';
            }else if(finalPath.getPrevious().y > finalPath.getAxis().y){
                directions[index++] = 'u';
            }
        }
        return new String(directions);
    }

    public String findShortestPath() throws Exception {
        Point current;
        queue.add(new QueueElement(maze.getStartAxis(), maze.getStartAxis()));

        while(!queue.isEmpty()){
            while(!queue.isEmpty() && findExistingPath(queue.getFirst().getTo()) != null){
                queue.removeFirst();
            }
            if (queue.isEmpty()){
                break;
            }
            paths.add(new Path(queue.getFirst().getTo(), queue.getFirst().getFrom()));

            current = queue.getFirst().getTo();
            queue.removeFirst();

            Point up = new Point(current.x, current.y-1);
            Point down = new Point(current.x, current.y+1);
            Point left = new Point(current.x-1, current.y);
            Point right = new Point(current.x+1, current.y);

            Point[] neighbors = new Point[]{up,down,left,right};
            for(Point neigh : neighbors){
                if(!checkIfOutOfRange(neigh)){
                    if (maze.getMazeElements().get(neigh.y).get(neigh.x).getType() == '.' || maze.getMazeElements().get(neigh.y).get(neigh.x).getType() == 'X' && findExistingPath(neigh) == null) {
                        queue.add(new QueueElement(current, neigh));
                    }
                }
            }
            if(findExistingPath(maze.getEndAxis()) != null){
                break;
            }
        }
        return getShortestPath();
    }

    public void verifyMaze() throws Exception {
        int startCounter = 0;
        int endCounter = 0;
        int previous = maze.getMazeElements().get(0).size();
        for(List<MazeElement> mazeElements : maze.getMazeElements()){
            if(previous != mazeElements.size()){
                throw new Exception("Bad dimensions");
            }
            for(MazeElement mazeElement : mazeElements){
                switch (mazeElement.getType()){
                    case 'S':
                        if(++startCounter > 1){
                            throw new Exception("Only one start point is allowed");
                        }
                        break;
                    case 'X':
                        if(++endCounter > 1){
                            throw new Exception("Only one end point is allowed");
                        }
                        break;
                    case '.':
                    case '#':
                        break;
                    default:
                        throw new Exception("Bad input. Allowed 'SX.#'");
                }
            }
        }
        if(startCounter == 0 || endCounter == 0){
            throw new Exception("Couldnt find start or end point");
        }
    }

    public boolean checkIfOutOfRange(Point point){
        if(point.x < 0 || point.x >= maze.getMazeElements().get(0).size()){
            return true;
        }else if(point.y < 0 || point.y >= maze.getMazeElements().size()){
            return true;
        }
        return false;
    }

    public Maze getMaze() {
        return maze;
    }
}
