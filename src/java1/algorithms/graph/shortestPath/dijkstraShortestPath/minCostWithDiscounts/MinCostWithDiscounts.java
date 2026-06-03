package java1.algorithms.graph.shortestPath.dijkstraShortestPath.minCostWithDiscounts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostWithDiscounts {
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class State {
        int node;
        int cost;
        int usedDiscounts;

        State(int node, int cost, int usedDiscounts) {
            this.node = node;
            this.cost = cost;
            this.usedDiscounts = usedDiscounts;
        }
    }

    //Using Dijkstra + discounts TC: O(E * K * log(VK)) SC: O(V * K)
    private int minCost(List<Edge>[] graph, int src, int dst, int maxDiscounts) {
        int n = graph.length;
        int[][] best = new int[n][maxDiscounts+1];

        for(int i=0; i<n; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new State(src, 0, 0));
        best[src][0] = 0;

        while(!pq.isEmpty()) {
            State curr = pq.poll();

            int node = curr.node;
            int cost = curr.cost;
            int usedDiscounts = curr.usedDiscounts;

            if(node == dst) {
                return cost;
            }

            if(usedDiscounts > maxDiscounts) continue;

            for(Edge edge: graph[node]) {

                //Take without discount
                int newCost = cost + edge.cost;
                if(newCost < best[node][usedDiscounts]) {
                    best[node][usedDiscounts] = newCost;
                    pq.offer(new State(edge.to, newCost, usedDiscounts));
                }

                //Take with discount if its is available
                if(newCost < best[node][usedDiscounts+1]) {
                    best[node][usedDiscounts+1] = newCost;
                    pq.offer(new State(edge.to, newCost, usedDiscounts+1));
                }

            }
        }

        return -1;//not reachable to destination
    }
}
