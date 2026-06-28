package java1.algorithms.heap.minCostToConnectSticks;

import java.util.PriorityQueue;

public class MinCostToConnectSticks {
    //Greedy + minHeap TC: O(n log n) SC: O(n)
    private static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int minCost = 0;

        for(int stick: sticks) {
            minHeap.offer(stick);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;
            minCost += cost;
            
            minHeap.offer(cost);
        }

        return minCost;
    }

        public static void main(String[] args) {

        System.out.println(connectSticks(new int[]{2, 4, 3}));              // 14
        System.out.println(connectSticks(new int[]{1, 8, 3, 5}));           // 30
        System.out.println(connectSticks(new int[]{5}));                    // 0
        System.out.println(connectSticks(new int[]{1, 2}));                 // 3
        System.out.println(connectSticks(new int[]{1, 2, 3, 4, 5}));        // 33
        System.out.println(connectSticks(new int[]{10, 20, 30}));           // 90
        System.out.println(connectSticks(new int[]{1, 1, 1, 1}));           // 8
        System.out.println(connectSticks(new int[]{100, 200, 300, 400}));   // 1900
    }

}
