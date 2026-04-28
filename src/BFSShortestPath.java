import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSShortestPath {

    public static List<Integer> shortestPath(int[][] graph, int start, int target) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == target) {
                break;
            }

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[current][neighbor] != 0 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        if (!visited[target]) {
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