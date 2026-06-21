package java1.algorithms.graph.graphTraversal.reorderRoutesLeadsToCity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReorderRoutesLeadsToCity {
    //DFS Recursion TC: O(n) (Build the graph -> O(n-1) Graph traversal:- O(V+E) -> O(n + n-1) -> O(n)) SC: O(n)(Adjaceny list + visited array + )
    private int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: connections) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }

        boolean[] visited= new boolean[n];
        return dfs(graph, 0, visited);
    }

    private int dfs(List<List<int[]>> graph, int city, boolean[] visited) {
        visited[city] = true;

        int changes = 0;

        for(int[] neighbour: graph.get(city)) {
            int nextCity = neighbour[0];
            int needsReverse = neighbour[1];

            if(!visited[nextCity]) {
                changes += needsReverse;
                changes += dfs(graph, nextCity, visited);
            }
        }

        return changes;
    }

    //BFS 
    private int minReorderBFS(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int[] edge: connections) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(new int[]{from, 1});
            graph.get(to).add(new int[]{to, 0});
        }

        Queue<Integer> queue = new LinkedList<>();
    }
}
