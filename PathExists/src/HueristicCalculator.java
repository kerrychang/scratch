
public class HueristicCalculator {

    private Point endPoint;
    
    public HueristicCalculator(Point endPoint) {
        this.endPoint = endPoint;
    }
    
    public double getHueristic(Point p) {
        
        int xDiff = endPoint.getX() - p.getX();
        int yDiff = endPoint.getY() - p.getY();
        
        double xDiffSquared = Math.pow(xDiff, 2);
        double yDiffSquared = Math.pow(yDiff, 2);
        
        return Math.sqrt(xDiffSquared + yDiffSquared);
    }
    
}
