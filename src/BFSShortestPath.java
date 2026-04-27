import java.util.*;

public class BFSShortestPath {

    public static List<Integer> shortestPath(int[][] graph, int start, int target) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == target) break;

            for (int i = 0; i < n; i++) {
                if (graph[current][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    queue.add(i);
                }
            }
        }

        // reconstruct path
        List<Integer> path = new ArrayList<>();
        if (!visited[target]) return path;

        for (int at = target; at != -1; at = parent[at]) {
            path.add(at);
        }

        Collections.reverse(path);
        return path;
    }
}