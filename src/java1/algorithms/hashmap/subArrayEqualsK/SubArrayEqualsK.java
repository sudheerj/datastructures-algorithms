package java1.algorithms.hashmap.subArrayEqualsK;

import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualsK {
    //Using prefix sum map TC: O(n) SC: O(n)
    private static int subArrayEqualsK(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // empty prefix has sum 0 and 1 instance

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            count += prefixSumMap.getOrDefault(sum - k, 0);
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test 1: two overlapping subarrays
        System.out.println(subArrayEqualsK(new int[] { 1, 1, 1 }, 2) + " (expected 2)"); // [1,1],[1,1]

        // Test 2: [1,2] and [3]
        System.out.println(subArrayEqualsK(new int[] { 1, 2, 3 }, 3) + " (expected 2)");

        // Test 3: single element equals k
        System.out.println(subArrayEqualsK(new int[] { 3 }, 3) + " (expected 1)");

        // Test 4: entire array is the only subarray
        System.out.println(subArrayEqualsK(new int[] { 1, 2, 3 }, 6) + " (expected 1)");

        // Test 5: every individual element qualifies
        System.out.println(subArrayEqualsK(new int[] { 1, 1, 1 }, 1) + " (expected 3)");

        // Test 6: negative numbers
        System.out.println(subArrayEqualsK(new int[] { -1, -1, 1 }, 0) + " (expected 1)"); // [-1,1]
    }
}
