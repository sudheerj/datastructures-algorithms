package java1.algorithms.graph.connectedComponents.numberOfConnectedComponents.dfsCount;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {
    //Treat every new DFS iteration as one component TC: O(V + E) SC: O(V + E)
    public static int countComponents(int n, int[][] edges) {
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

        boolean[] visited = new boolean[n];
        int components =0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                components++;

                dfs(i, graph, visited);
            }
        }

        return components;
    }

    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for(int neighbor: graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        System.out.println(countComponents(n, edges));
    }
}
