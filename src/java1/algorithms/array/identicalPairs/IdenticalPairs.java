package java1.algorithms.array.identicalPairs;

import java.util.HashMap;
import java.util.Map;

public class IdenticalPairs {
    // Approach 1: Frequency counting (running total) TC: O(n) SC: O(n)
    public static int findIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            if (frequencyMap.containsKey(num)) {
                count += frequencyMap.get(num);
            }
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    // Approach 2: Combinatorics — nC2 = n*(n-1)/2 per group TC: O(n) SC: O(n)
    public static int findIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int c : frequencyMap.values()) {
            count += (c * (c - 1)) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        Object[][] tests = {
                new Object[] { new int[] { 6, 3, 1, 5, 3, 6, 5, 6 }, 5 }, // mixed duplicates
                new Object[] { new int[] { 2, 2, 2, 2 }, 6 }, // all same: 4C2=6
                new Object[] { new int[] { 1, 2, 3, 4 }, 0 }, // all distinct
                new Object[] { new int[] { 1, 1 }, 1 }, // single pair
                new Object[] { new int[] { 1 }, 0 }, // single element
        };

        System.out.println("--- Approach 1: Frequency Counting ---");
        for (Object[] t : tests) {
            int[] nums = (int[]) t[0];
            int expected = (int) t[1];
            int result = findIdenticalPairs(nums);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }

        System.out.println("--- Approach 2: Combinatorics ---");
        for (Object[] t : tests) {
            int[] nums = (int[]) t[0];
            int expected = (int) t[1];
            int result = findIdenticalPairs2(nums);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }
}
