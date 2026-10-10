package java1.algorithms.graph.mst.prim.minCostToConnectAll;

import java.util.PriorityQueue;

public class MinCostToConnectAll {
    // Prim's algorithm with a min-heap: TC O(n^2 log n), SC O(n^2)
    public static int minCostToConnect(int[][] points) {
        int n = points.length;

        // {cost, point}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { 0, 0 });

        boolean[] visited = new boolean[n];
        int totalMinCost = 0;
        int connectedPoints = 0;

        while (connectedPoints < n) {
            int[] node = pq.poll();
            int cost = node[0];
            int point = node[1];

            if (visited[point]) {
                continue;
            }

            visited[point] = true;
            totalMinCost += cost;
            connectedPoints++;

            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int nextCost = Math.abs(points[point][0] - points[next][0])
                            + Math.abs(points[point][1] - points[next][1]);
                    pq.offer(new int[] { nextCost, next });
                }
            }
        }

        return totalMinCost;
    }

    public static void main(String[] args) {
        int[][] points1 = {
                { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 }
        };
        int[][] points2 = {
                { 3, 12 }, { -2, 5 }, { -4, 1 }
        };
        int[][] points3 = {
                { 1, 1 }
        };

        int[] results = {
                minCostToConnect(points1),
                minCostToConnect(points2),
                minCostToConnect(points3)
        };
        int[] expected = { 20, 18, 0 };

        for (int i = 0; i < results.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + results[i]
                    + " (expected " + expected[i] + ") "
                    + (results[i] == expected[i] ? "PASS" : "FAIL"));
        }
    }
}
