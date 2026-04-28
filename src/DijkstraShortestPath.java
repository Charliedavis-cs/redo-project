import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DijkstraShortestPath {

    public static List<Integer> shortestPath(int[][] graph, int start, int target) {
        int n = graph.length;

        int[] distance = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            distance[i] = 999999;
            parent[i] = -1;
        }

        distance[start] = 0;

        for (int count = 0; count < n; count++) {
            int current = -1;
            int smallest = 999999;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < smallest) {
                    smallest = distance[i];
                    current = i;
                }
            }

            if (current == -1) {
                break;
            }

            visited[current] = true;

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[current][neighbor] > 0 && !visited[neighbor]) {
                    int newDistance = distance[current] + graph[current][neighbor];

                    if (newDistance < distance[neighbor]) {
                        distance[neighbor] = newDistance;
                        parent[neighbor] = current;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        if (distance[target] == 999999) {
            return path;
        }

        int current = target;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);
        return path;
    }
}