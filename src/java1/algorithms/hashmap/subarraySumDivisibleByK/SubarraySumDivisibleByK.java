package java1.algorithms.hashmap.subarraySumDivisibleByK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    // Prefix sums and remainder frequencies: TC: O(n), SC: O(n)
    public static int subArrSumDivisibleByK(int[] nums, int k) {
        Map<Integer, Integer> prefixRemainderMap = new HashMap<>();
        prefixRemainderMap.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k;
            }

            count += prefixRemainderMap.getOrDefault(remainder, 0);
            prefixRemainderMap.put(remainder, prefixRemainderMap.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] numsTests = {
                { 4, 5, 0, -2, -3, 1 },
                { 5 },
                { 1, 2, 3 },
                { -1, 2, 9 },
                { 0, 0, 0 },
                { 1, 2, 3 }
        };
        int[] divisors = { 5, 9, 5, 2, 1, 7 };
        int[] expected = { 7, 0, 1, 2, 6, 0 };
        String[] labels = {
                "Example 1: mixed positive and negative values",
                "no divisible subarray",
                "whole-array sum divisible by k",
                "negative prefix remainder",
                "all zero values with k = 1",
                "no matching prefix remainders"
        };

        for (int i = 0; i < numsTests.length; i++) {
            int actual = subArrSumDivisibleByK(numsTests[i], divisors[i]);
            System.out.println("[" + (actual == expected[i] ? "PASS" : "FAIL") + "] "
                    + labels[i] + ": " + actual + " (expected " + expected[i] + ")");
        }
    }
}
