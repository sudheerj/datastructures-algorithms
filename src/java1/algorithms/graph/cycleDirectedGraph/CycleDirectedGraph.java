package java1.algorithms.graph.cycleDirectedGraph;

import java.util.List;

public class CycleDirectedGraph {
    // Recursive DFS + visited & path visited arrays => TC: O(V+E) SC: O(V)
    private boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        //check every component
        for(int i=0; i<V; i++) {
            //if node not visited
            if(!visited[i]) {
                if(dfs(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        //mark as visited
        visited[node] = true;

        //mark as DFS recursion path visited
        pathVisited[node] = true;

        //explore neighbours
        for(int neighbour: adj.get(node)) {

            //if neighbour not visited
            if(!visited[neighbour]) {
                if(dfs(neighbour, adj, visited, pathVisited)) {
                    return true;
                }
            }

            //if neighbour is already in DFS recursion path => cycle detected
            if(pathVisited[neighbour]) {
                return true;
            }
        }

        //Remove node from DFS recursion path
        pathVisited[node] = false;

        return false;
    }

    public static void main(String[] args) {
        CycleDirectedGraph sol = new CycleDirectedGraph();

        // Test 1: Simple cycle: 0->1->2->0
        List<List<Integer>> adj1 = List.of(
            List.of(1),   // 0 -> 1
            List.of(2),   // 1 -> 2
            List.of(0)    // 2 -> 0 (cycle)
        );
        System.out.println(sol.isCycle(3, adj1)); // Expected: true

        // Test 2: No cycle: simple DAG 0->1->2->3
        List<List<Integer>> adj2 = List.of(
            List.of(1),   // 0 -> 1
            List.of(2),   // 1 -> 2
            List.of(3),   // 2 -> 3
            List.of()     // 3
        );
        System.out.println(sol.isCycle(4, adj2)); // Expected: false

        // Test 3: Self-loop: node 1 points to itself
        List<List<Integer>> adj3 = List.of(
            List.of(1),   // 0 -> 1
            List.of(1)    // 1 -> 1 (self-loop)
        );
        System.out.println(sol.isCycle(2, adj3)); // Expected: true

        // Test 4: Disconnected graph — second component has a cycle
        List<List<Integer>> adj4 = List.of(
            List.of(),    // 0 (isolated)
            List.of(2),   // 1 -> 2
            List.of(3),   // 2 -> 3
            List.of(1)    // 3 -> 1 (cycle in component 1-2-3)
        );
        System.out.println(sol.isCycle(4, adj4)); // Expected: true

        // Test 5: Single node, no edges
        List<List<Integer>> adj5 = List.of(List.of());
        System.out.println(sol.isCycle(1, adj5)); // Expected: false
    }
}
