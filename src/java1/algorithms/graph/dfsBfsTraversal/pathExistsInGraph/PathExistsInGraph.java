package java1.algorithms.graph.dfsBfsTraversal.pathExistsInGraph;

import java.util.ArrayList;
import java.util.List;

public class PathExistsInGraph {
    //DFS traversal: TC: O(V+E) SC: O(V+E)
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visted = new boolean[n];
        return dfs(graph, source, destination, visted);
    }

    public static boolean dfs(List<List<Integer>> graph, int source, int destination, boolean[] visited) {
        if(source == destination) {
            return true;
        }

        visited[source] = true;

        for(int neighbour: graph.get(source)) {
            if(!visited[neighbour]) {
                if(dfs(graph, neighbour, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 6;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };

        int source = 0;
        int destination = 2;

        boolean result = validPath(
                n,
                edges,
                source,
                destination
        );

        System.out.println(result);
    }
}
