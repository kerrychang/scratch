import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class PathFinder {

    private int[][] graph;
    private Point start;
    private Point end;
    private HueristicCalculator hueristicCalc;

    public PathFinder(int[][] graph, Point start, Point end, HueristicCalculator hueristicCalc) {
        this.graph = graph;
        this.start = start;
        this.end = end;
        this.hueristicCalc = hueristicCalc;
    }

    /**
     * BFS
     */
    public boolean pathExists() {
        //0 means walkable
        //1 means blocked

        Map<Point, Integer> seen = new HashMap<Point, Integer>();
        Queue<Point> queue = new ArrayDeque<Point>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Point current = queue.remove();
            int x = current.getX();
            int y = current.getY();
            
            if (x < 0 || x >= graph.length 
                    || y < 0 || y >= graph[0].length 
                    || seen.containsKey(current)) {
                continue;
            }

            seen.put(current, 1);
            if (end.getX() == x && end.getY() == y) { //end state
                return true;
            } else if (graph[x][y] == 1) {
                continue;
            } else {
                // add all points into queue
                queue.add(new Point(x-1, y));
                queue.add(new Point(x+1, y));
                queue.add(new Point(x, y-1));
                queue.add(new Point(x, y+1));
            }

        }
        return false;
    }
    
    /**
     * BFS
     */
    public Path getShortestPathBFS() {
        //0 means walkable
        //1 means blocked
        //2 means goal state

        Map<Point, Integer> seen = new HashMap<Point, Integer>();
        Queue<Path> queue = new ArrayDeque<Path>();
        queue.add(new Path(start, new ArrayList<Point>(), 0));

        int nodeProcessed = 0;
        
        while(!queue.isEmpty()) {
            Path path = queue.remove();
            
            System.out.println("nodeProcessed: " + ++nodeProcessed);
            
            Point currentPoint = path.getCurrentPoint();
            int x = currentPoint.getX();
            int y = currentPoint.getY();

            if (x < 0 || x >= graph.length 
                    || y < 0 || y >= graph[0].length 
                    || seen.containsKey(currentPoint)) {
                continue;
            }

            seen.put(currentPoint, 1);
            if (end.getX() == x && end.getY() == y) { //end state
                return path;
            } else if (graph[x][y] == 1) {
                continue;
            } else {
                // add all points into queue
                List<Point> previousPoints = new ArrayList<Point>(path.getPreviousPoints());
                previousPoints.add(currentPoint);
                queue.add(new Path(new Point(x-1, y), previousPoints, 0));
                queue.add(new Path(new Point(x+1, y), previousPoints, 0));
                queue.add(new Path(new Point(x, y-1), previousPoints, 0));
                queue.add(new Path(new Point(x, y+1), previousPoints, 0));
            }

        }
        
        return null;
    }
    
    /**
     * A*
     */
    public Path getShortestPathAStar() {
        //0 means walkable
        //1 means blocked
        //2 means goal state

        Map<Point, Integer> seen = new HashMap<Point, Integer>();
        PriorityQueue<Path> queue = new PriorityQueue<Path>();
        queue.add(new Path(start, new ArrayList<Point>(), hueristicCalc.getHueristic(start)));

        while(!queue.isEmpty()) {
            Path path = queue.poll();
            
            Point currentPoint = path.getCurrentPoint();
            int x = currentPoint.getX();
            int y = currentPoint.getY();

            if (x < 0 || x >= graph.length 
                    || y < 0 || y >= graph[0].length 
                    || seen.containsKey(currentPoint)) {
                continue;
            }

            seen.put(currentPoint, 1);
            if (end.getX() == x && end.getY() == y) { //end state
                return path;
            } else if (graph[x][y] == 1) {
                continue;
            } else {
                // add all points into queue
                List<Point> previousPoints = new ArrayList<Point>(path.getPreviousPoints());
                previousPoints.add(currentPoint);
                
                Point up = new Point(x, y+1);
                Point down = new Point(x, y-1);
                Point left = new Point(x-1, y);
                Point right = new Point(x+1, y);
                
                queue.add(new Path(up, previousPoints, hueristicCalc.getHueristic(up)));
                queue.add(new Path(down, previousPoints, hueristicCalc.getHueristic(down)));
                queue.add(new Path(left, previousPoints, hueristicCalc.getHueristic(left)));
                queue.add(new Path(right, previousPoints, hueristicCalc.getHueristic(right)));
            }

        }
        
        return null;
    }
}
