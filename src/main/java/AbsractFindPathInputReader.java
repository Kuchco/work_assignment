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

    public List<Path> getShortestPath(){
        List<Path> shortestPath = new ArrayList<>();
        Path path = findExistingPath(maze.getEndAxis());
        if(path == null){
            System.out.println("Couldnt find a path");
            return null;
        }
        while(path.getAxis() != maze.getStartAxis()){
            shortestPath.add(path);
            path = findExistingPath(path.getPrevious());
        }
        Collections.reverse(shortestPath);
        for(Path finalPath : shortestPath){
            if(finalPath.getPrevious().x < finalPath.getAxis().x){
                System.out.print("r");
            }else if(finalPath.getPrevious().x > finalPath.getAxis().x){
                System.out.print("l");
            }else if(finalPath.getPrevious().y < finalPath.getAxis().y){
                System.out.print("d");
            }else if(finalPath.getPrevious().y > finalPath.getAxis().y){
                System.out.print("u");
            }
        }
        return shortestPath;
    }

    public List<Path> findShortestPath() {
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
                    if (maze.getMazeElements().get(neigh.y).get(neigh.x).getType() == 0 || maze.getMazeElements().get(neigh.y).get(neigh.x).getType() == 4 && findExistingPath(neigh) == null) {
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
