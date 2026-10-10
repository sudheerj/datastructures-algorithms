package java1.algorithms.graph.shortestPath.dijkstra.findShortestPathKHops;

import java.util.*;

public class FindShortestPathKHops {

    // Dijkstra + Min Heap + Stops
    // TC: O(K * E log(K * V))
    // SC: O(K * V + E)
    public static int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(new int[] { to, price });
        }

        /*
         * dist[city][flightsUsed] is the cheapest cost to reach city
         * using exactly flightsUsed flights.
         */
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Each state is {cost, city, flightsUsed}.
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[] { 0, src, 0 });
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int city = curr[1];
            int flightsUsed = curr[2];

            // The min-heap guarantees this is the cheapest valid destination state.
            if (city == dst) {
                return cost;
            }

            // At most k stops allows at most k + 1 flights.
            if (flightsUsed == k + 1) {
                continue;
            }

            for (int[] flight : graph.get(city)) {
                int nextCity = flight[0];
                int price = flight[1];
                int newCost = cost + price;
                int newFlightsUsed = flightsUsed + 1;

                if (newCost < dist[nextCity][newFlightsUsed]) {
                    dist[nextCity][newFlightsUsed] = newCost;
                    pq.offer(new int[] { newCost, nextCity, newFlightsUsed });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 2, 3, 100 },
                { 0, 2, 500 }
        };

        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}
