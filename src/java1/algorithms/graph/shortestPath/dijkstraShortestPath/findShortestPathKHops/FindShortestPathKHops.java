package java1.algorithms.graph.shortestPath.dijkstraShortestPath.findShortestPathKHops;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindShortestPathKHops {
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State {
        int node;
        int cost;
        int hops;

        State(int node, int cost, int hops) {
            this.node = node;
            this.cost = cost;
            this.hops = hops;
        }
    }

    //Using Dijkstra + hops TC: O(E * K * log(VK)) SC: O(V * K)
    public int shortestPathWithKHops(List<Edge>[] graph, int src, int dst, int k) {
        int n = graph.length;

        int[][] best = new int[n][k+1]; //min cost to reach node using exactly hops edges

        for(int i=0; i<n; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new State(src, 0, 0));
        best[src][0] = 0;

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            int node = curr.node;
            int cost = curr.cost;
            int hops = curr.hops;

            //if we reached destination, return the cost
            if(node == dst) {
                return cost;
            }

            //cannot exceed hops
            if(hops > k) continue;

            //explore all edges
            for(Edge edge: graph[node]) {
                int newCost = cost + edge.weight;
                int newHops = hops + 1;

                if(newCost < best[edge.to][newHops]) {
                    best[edge.to][newHops] = newCost;

                    pq.offer(new State(edge.to, newCost, newHops));
                }
            }
        }

        return -1;// not reachable to destination
    }

    public static void main(String[] args) {
        FindShortestPathKHops solution = new FindShortestPathKHops();

        // Test case 1: Simple path with k=1
        System.out.println("Test case 1:");
        @SuppressWarnings("unchecked")
        List<Edge>[] graph1 = new List[4];
        for (int i = 0; i < 4; i++) {
            graph1[i] = Arrays.asList();
        }
        graph1[0] = Arrays.asList(new Edge(1, 100), new Edge(2, 500));
        graph1[1] = Arrays.asList(new Edge(2, 100));
        graph1[2] = Arrays.asList(new Edge(3, 100));
        graph1[3] = Arrays.asList();
        
        int result1 = solution.shortestPathWithKHops(graph1, 0, 3, 1);
        System.out.println("Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)");
        System.out.println("Source: 0, Destination: 3, K: 1");
        System.out.println("Output: " + result1);
        System.out.println("Expected: -1 (need at least 2 hops)");
        System.out.println();

        // Test case 2: Direct path vs longer path
        System.out.println("Test case 2:");
        @SuppressWarnings("unchecked")
        List<Edge>[] graph2 = new List[4];
        for (int i = 0; i < 4; i++) {
            graph2[i] = Arrays.asList();
        }
        graph2[0] = Arrays.asList(new Edge(1, 100), new Edge(2, 500));
        graph2[1] = Arrays.asList(new Edge(2, 100));
        graph2[2] = Arrays.asList(new Edge(3, 100));
        graph2[3] = Arrays.asList();
        
        int result2 = solution.shortestPathWithKHops(graph2, 0, 3, 2);
        System.out.println("Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)");
        System.out.println("Source: 0, Destination: 3, K: 2");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 600 (0->2->3 with cost 500+100=600)");
        System.out.println();

        // Test case 3: Multiple paths with different costs
        System.out.println("Test case 3:");
        @SuppressWarnings("unchecked")
        List<Edge>[] graph3 = new List[4];
        for (int i = 0; i < 4; i++) {
            graph3[i] = Arrays.asList();
        }
        graph3[0] = Arrays.asList(new Edge(1, 100), new Edge(2, 500));
        graph3[1] = Arrays.asList(new Edge(2, 100));
        graph3[2] = Arrays.asList(new Edge(3, 100));
        graph3[3] = Arrays.asList();
        
        int result3 = solution.shortestPathWithKHops(graph3, 0, 3, 3);
        System.out.println("Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)");
        System.out.println("Source: 0, Destination: 3, K: 3");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 300 (0->1->2->3 with cost 100+100+100=300)");
        System.out.println();

        // Test case 4: Flight prices example
        System.out.println("Test case 4:");
        @SuppressWarnings("unchecked")
        List<Edge>[] graph4 = new List[3];
        for (int i = 0; i < 3; i++) {
            graph4[i] = Arrays.asList();
        }
        graph4[0] = Arrays.asList(new Edge(1, 100));
        graph4[1] = Arrays.asList(new Edge(2, 100), new Edge(0, 100));
        graph4[2] = Arrays.asList(new Edge(0, 100));
        
        int result4 = solution.shortestPathWithKHops(graph4, 0, 2, 1);
        System.out.println("Graph: 0->(1:100), 1->(2:100, 0:100), 2->(0:100)");
        System.out.println("Source: 0, Destination: 2, K: 1");
        System.out.println("Output: " + result4);
        System.out.println("Expected: 200 (0->1->2 with cost 100+100=200)");
        System.out.println();

        // Test case 5: No path possible
        System.out.println("Test case 5:");
        @SuppressWarnings("unchecked")
        List<Edge>[] graph5 = new List[4];
        for (int i = 0; i < 4; i++) {
            graph5[i] = Arrays.asList();
        }
        graph5[0] = Arrays.asList(new Edge(1, 100));
        graph5[1] = Arrays.asList(new Edge(2, 100));
        graph5[2] = Arrays.asList();
        graph5[3] = Arrays.asList();
        
        int result5 = solution.shortestPathWithKHops(graph5, 0, 3, 5);
        System.out.println("Graph: 0->(1:100), 1->(2:100), 2->(), 3->()");
        System.out.println("Source: 0, Destination: 3, K: 5");
        System.out.println("Output: " + result5);
        System.out.println("Expected: -1 (no path from 0 to 3)");
    }
}
