import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbsractFindPathInputReader {
    private Maze maze = new Maze();
    private LinkedList<QueueElement> queue = new LinkedList<>();
    private List<PathAndCost> pathsAndCosts = new ArrayList<>();

    public PathAndCost findExistingPath(int element){
        for(PathAndCost path : pathsAndCosts){
            if(path.getAxis() == element){
                return path;
            }
        }
        return null;
    }

    public List<Integer> getShortestPath(){
        List<Integer> shortestPath = new ArrayList<>();
        PathAndCost path = findExistingPath(maze.getEnd());
        while(path.getAxis() != maze.getStart()){
            shortestPath.add(path.getAxis());
            path = findExistingPath(path.getPrevious());
        }
        return shortestPath;
    }

    public void findShortestPath() {
        int current;
        queue.add(new QueueElement(maze.getStart(), maze.getStart(), 1));

        while(!queue.isEmpty()){
            while(!queue.isEmpty() && findExistingPath(queue.getFirst().getTo()) != null){
                queue.removeFirst();
            }
            if (queue.isEmpty()){
                break;
            }
            pathsAndCosts.add(new PathAndCost(queue.getFirst().getTo(), queue.getFirst().getFrom(), queue.getFirst().getCost()));

            current = queue.getFirst().getTo();
            queue.removeFirst();

            int up = current - maze.getWidth();
            int down = current + maze.getWidth();
            int left = current - 1;
            int right = current + 1;

            if(current == 422){
                System.out.println("noise");
            }

            int[] noise = new int[]{up,down,left,right};
            for(int neigh : noise){
                if(neigh >= 0 && neigh < (maze.getWidth() * maze.getHeight()) && right%maze.getWidth() != 0 && left+1% maze.getWidth() != 0){
                    if (maze.getMazeElements().get(neigh).getType() == 0 || maze.getMazeElements().get(neigh).getType() == 4 && findExistingPath(neigh) == null) {
                        queue.add(new QueueElement(current, neigh, 1));
                    }
                }
            }
            if(findExistingPath(maze.getEnd()) != null){
                break;
            }
        }
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public LinkedList<QueueElement> getQueue() {
        return queue;
    }

    public void setQueue(LinkedList<QueueElement> queue) {
        this.queue = queue;
    }

    public List<PathAndCost> getPathsAndCosts() {
        return pathsAndCosts;
    }

    public void setPathsAndCosts(List<PathAndCost> pathsAndCosts) {
        this.pathsAndCosts = pathsAndCosts;
    }
}
