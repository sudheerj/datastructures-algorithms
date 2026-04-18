package java1.algorithms.graph.networkDelayTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayTime {
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

    //Dijkstra's algorithm TC: O(E logv) SC: O(V+E)
    private static int networkDelayTime(int[][] times, int n, int k) {
        // Build adjaceny list
        Map<Integer, List<int[]>> adjacenyList = new HashMap<>();
        for (int[] t : times) {
            adjacenyList.computeIfAbsent(t[0], x -> new ArrayList<>())
                    .add(new int[] { t[1], t[2] });
        }

        // min-heap: (time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
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

            if (adjacenyList.containsKey(node)) {
                for (int[] nei : adjacenyList.get(node)) {
                    if (!visited.contains(nei[0])) {
                        pq.offer(new int[] {
                                currTime + nei[1],
                                nei[0]
                        });
                    }
                }
            }
        }
        return visited.size() == n ? time : -1;
    }
}
