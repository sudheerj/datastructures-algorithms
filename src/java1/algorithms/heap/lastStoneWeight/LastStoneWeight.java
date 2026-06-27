package java1.algorithms.heap.lastStoneWeight;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    //Max heap to find the largest stones TC: O(n log n) SC: O(n)
    private static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int x = maxHeap.poll(); //largest stone
            int y = maxHeap.poll(); //second largest stone

            if(x != y) {
                maxHeap.offer(x-y);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {

        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones1)); // 1

        int[] stones2 = {1};
        System.out.println(lastStoneWeight(stones2)); // 1

        int[] stones3 = {10, 10};
        System.out.println(lastStoneWeight(stones3)); // 0

        int[] stones4 = {9, 3, 2, 10};
        System.out.println(lastStoneWeight(stones4));

        int[] stones5 = {5, 5, 5, 5};
        System.out.println(lastStoneWeight(stones5)); // 0
    }
}
