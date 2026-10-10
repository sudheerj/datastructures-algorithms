package java1.algorithms.graph.cycleDetection.undirectedCycleDetection.dfsParent.hasCycle;

import java.util.ArrayList;
import java.util.List;

public class HasCycle {
    //DFS + Parent: TC: O(V + E) SC: O(V)
    public static boolean hasCycle(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];

        for(int node=0; node<n; node++) {
            if(!visited[node]) {
                if(dfs(node, -1, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        //visit neighbour nodes
        for(int neighbor: graph.get(node)) {
            if(!visited[neighbor]) {
                if(dfs(neighbor, node, graph, visited)) {
                    return true;
                }
            } else if(neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
         int n = 4;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 0 -- 1
        // |    |
        // 3 -- 2
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(0);
        graph.get(0).add(3);

        System.out.println(hasCycle(n, graph));       
    }
}
