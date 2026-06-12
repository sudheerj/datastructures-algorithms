package java1.algorithms.heap.minRefuelStops;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinRefuelStops {
    //Greedy + MaxHeap(deferred decision)
    private int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int fuel = startFuel;
        int n =stations.length;
        int stops = 0;
        int i =0;

        while(fuel < target) {

            //Add all reachable stations
            while(i < n && stations[i][0] <= fuel) {
                pq.offer(stations[i][1]);
                i++;
            }

            //no fuel options -> impossible to reach target
            if(pq.isEmpty()) {
                return -1;
            }

            fuel += pq.poll();
            stops++;
        }

        return stops;
    }
}
