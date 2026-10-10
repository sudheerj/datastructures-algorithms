import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightKHops {
    public static int findCheapestFlight(int n, int[][] flights, int src, int dest, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            graph.get(from).add(new int[]{to, cost});
        }

        //{city,kstops} => cost
        int[][] dist = new int[n][k+2];
        for(int[] row: dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src, 0});

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int cost = node[0];
            int fromCity = node[1];
            int flightsUsed  = node[2];
            
            if(fromCity == dest) {
                return cost;
            }

            if(flightsUsed == k+1) {
                continue;
            } 

            for(int[] edge: graph.get(fromCity)) {
                int nextCity = edge[0];
                int nextCost = edge[1];
                int newCost = cost + nextCost;
                int newFlightsUsed = flightsUsed + 1;

                if(newCost < dist[nextCity][newFlightsUsed]) {
                    dist[nextCity][newFlightsUsed] = newCost;
                    pq.offer(new int[]{newCost, nextCity, newFlightsUsed});
                }
            }
        }
        return -1;
    }
}
