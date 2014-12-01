
public class Main {

    public static void main(String[] args) {

        // [0, 0, 1, 0]
        // [0, 0, 1, 0]
        // [0, 0, 1, 0]
        // [0, 0, 1, 2]

        int[][] graph = new int[][] {
                { 0, 0, 0 },
                { 1, 0, 0 },
                { 0, 0, 0 },
        };

        Point start = new Point(0, 0);
        Point end = new Point(0, 2);
        HueristicCalculator hueristicCalc = new HueristicCalculator(end);
        PathFinder pathFinder = new PathFinder(graph, start, end, hueristicCalc);
        System.out.println(pathFinder.pathExists());
        
//        System.out.println(pathFinder.getShortestPathBFS());
//        System.out.println(pathFinder.getShortestPathAStar());
        System.out.println(pathFinder.pathExistsAgain());
        
    }

}
