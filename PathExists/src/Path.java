import java.util.List;


public class Path implements Comparable {

    private Point currentPoint;
    private List<Point> previousPoints;
    private double hueristicCost;
    
    public Path(Point currentPoint, List<Point> previousPoints, double hueristicCost) {
        this.currentPoint = currentPoint;
        this.previousPoints = previousPoints;
        this.hueristicCost = hueristicCost;
    }
    
    public Point getCurrentPoint() {
        return currentPoint;
    }
    
    public List<Point> getPreviousPoints() {
        return previousPoints;
    }
    
    @Override
    public String toString() {
        String s = "Path: ";
        for (Point p : previousPoints) {
            s = s + "(" + p.getX() + ", " + p.getY() + "), ";
        }
        s = s + "(" + currentPoint.getX() + ", " + currentPoint.getY() + ")";
        return s;
    }

    @Override
    public int compareTo(Object o) {
        Path other = (Path) o;
        
        if (this.hueristicCost < other.hueristicCost) {
            return -1;
        } else if (this.hueristicCost == other.hueristicCost) {
            return 0;
        } else {
            return 1;
        }
    }
    
}
