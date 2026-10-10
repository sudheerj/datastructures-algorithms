package java1.algorithms.heap.maxScoreAfterKOperations;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxScoreAfterKOperations {
    // Greedy + Heap/Priority queue: TC: O(n + k log n) SC: O(n)
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // push elements into max heap
        for (int num : nums) {
            pq.offer(num);
        }

        long score = 0;

        while (k-- > 0) {
            // 1. Find max element
            int max = pq.poll();
            // 2. Add max element to score
            score += max;
            // 3. Divide max number by 3 and replace with ceiling value
            max = (max + 2) / 3;
            // 4. Push back to heap
            pq.offer(max);
        }

        return score;
    }

    public static void main(String[] args) {
        int[][] testNums = {
                { 10, 10, 10, 10, 10 },
                { 1, 10, 3, 3, 3 },
                { 5 },
                { 2, 4, 6 }
        };
        int[] operations = { 5, 3, 4, 1 };
        long[] expected = { 50, 17, 9, 6 };

        for (int i = 0; i < testNums.length; i++) {
            long actual = maxKelements(testNums[i], operations[i]);
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + (actual == expected[i] ? " [PASS]" : " [FAIL]"));
        }
    }
}
