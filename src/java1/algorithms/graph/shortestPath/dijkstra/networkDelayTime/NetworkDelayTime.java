package java1.algorithms.graph.shortestPath.dijkstra.networkDelayTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayTime {

    // Dijkstra's algorithm TC: O(E log V) SC: O(V+E)
    private static int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list; each edge is stored as {neighbor, travelTime}.
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] t : times) {
            adjacencyList.get(t[0]).add(new int[] { t[1], t[2] });
        }

        // min-heap: (time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { 0, k });

        Set<Integer> visited = new HashSet<>();
        int time = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0], node = curr[1];

            if (visited.contains(node))
                continue;
            visited.add(node);
            time = Math.max(time, currTime);

            for (int[] edge : adjacencyList.get(node)) {
                int neighbor = edge[0];
                int edgeTime = edge[1];

                if (!visited.contains(neighbor)) {
                    pq.offer(new int[] {
                            currTime + edgeTime,
                            neighbor
                    });
                }
            }
        }
        return visited.size() == n ? time : -1;
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] times1 = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n1 = 4, k1 = 2;
        System.out.println("Test 1: " + networkDelayTime(times1, n1, k1)); // Expected: 2

        // Test case 2
        int[][] times2 = { { 1, 2, 1 } };
        int n2 = 2, k2 = 1;
        System.out.println("Test 2: " + networkDelayTime(times2, n2, k2)); // Expected: 1

        // Test case 3
        int[][] times3 = { { 1, 2, 1 } };
        int n3 = 2, k3 = 2;
        System.out.println("Test 3: " + networkDelayTime(times3, n3, k3)); // Expected: -1

        // Test case 4: Disconnected graph
        int[][] times4 = { { 1, 2, 1 }, { 2, 3, 2 } };
        int n4 = 4, k4 = 1;
        System.out.println("Test 4: " + networkDelayTime(times4, n4, k4)); // Expected: -1
    }
}
