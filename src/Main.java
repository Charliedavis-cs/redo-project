import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[][] unweightedGraph = {
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        List<Integer> bfsPath = BFSShortestPath.shortestPath(unweightedGraph, 0, 3);
        System.out.println("Problem 2 BFS Shortst Path:");
        System.out.println(bfsPath);
        int[][] weightedGraph = {
                {0, 4, 1, 0},
                {0, 0, 2, 5},
                {0, 0, 0, 8},
                {0, 0, 0, 0}
        };

        List<Integer> dijkstraPath = DijkstraShortestPath.shortestPath(weightedGraph, 0, 3);
        System.out.println("\nProblem 3 Dijkstra Shortest Path:");
        System.out.println(dijkstraPath);


        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] order = CourseSchedule.findOrder(numCourses, prerequisites);
        System.out.println("\nProblem 4 Course Schedule: ");
        System.out.println(Arrays.toString(order));
    }
}