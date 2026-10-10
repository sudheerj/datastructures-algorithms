package java1.algorithms.graph.dfsBfsTraversal.minPathScoreTwoCities;

import java.util.*;

public class MinPathScoreTwoCities {

    // DFS approach TC: O(U + V) SC: O(U + V)
    public static int minScore(int n, int[][] roads) {

        // 1. Build the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph.get(u).add(new int[] { v, weight });
            graph.get(v).add(new int[] { u, weight });
        }

        // 2. DFS from city 1
        boolean[] visited = new boolean[n + 1];
        return dfs(1, graph, visited, Integer.MAX_VALUE);
    }

    private static int dfs(int city, List<List<int[]>> graph, boolean[] visited, int currentMin) {
        visited[city] = true;

        for (int[] edge : graph.get(city)) {
            int nextCity = edge[0];
            int weight = edge[1];

            // Take minimum edge
            currentMin = Math.min(currentMin, weight);

            // Visit unvisited city
            if (!visited[nextCity]) {
                currentMin = dfs(nextCity, graph, visited, currentMin);
            }
        }
        return currentMin;
    }

    // BFS approach TC: O(U + V) SC: O(U + V)
    public static int minScore1(int n, int[][] roads) {
        // 1. Build the graph
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph.get(u).add(new int[] { v, weight });
            graph.get(v).add(new int[] { u, weight });
        }

        // 2.Traverse from city 1
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;

        // 3.Take minimum edge
        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int[] edge : graph.get(city)) {
                int nextCity = edge[0];
                int weight = edge[1];

                answer = Math.min(answer, weight);

                // Visit unvisted city
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] roads1 = {
                { 1, 2, 9 }, { 2, 3, 6 }, { 2, 4, 5 }, { 1, 4, 7 }
        };
        int[][] roads2 = {
                { 1, 2, 7 }, { 1, 3, 9 }, { 2, 3, 4 },
                { 2, 4, 8 }, { 3, 5, 6 }, { 4, 5, 3 }
        };

        int[][][] testRoads = { roads1, roads2 };
        int[] cityCounts = { 4, 5 };
        int[] expectedScores = { 5, 3 };

        for (int i = 0; i < testRoads.length; i++) {
            int dfsScore = minScore(cityCounts[i], testRoads[i]);
            int bfsScore = minScore1(cityCounts[i], testRoads[i]);

            System.out.println("Test " + (i + 1) + " (n=" + cityCounts[i] + "):");
            System.out.println("  Expected: " + expectedScores[i]);
            System.out.println("  DFS: " + dfsScore + (dfsScore == expectedScores[i] ? " [PASS]" : " [FAIL]"));
            System.out.println("  BFS: " + bfsScore + (bfsScore == expectedScores[i] ? " [PASS]" : " [FAIL]"));
        }
    }
}
