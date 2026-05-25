package java1.algorithms.hashmap.continousSubarraySum;

import java.util.HashMap;
import java.util.Map;

public class ContinousSubarraySum {

    // Approach 1: Brute force TC: O(n²) SC: O(1)
    private static boolean checkSubarraySum1(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0)
                    return true;
            }
        }
        return false;
    }

    // Approach 2: Prefix sum + HashMap TC: O(n) SC: O(min(n, k))
    private static boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int remainder = total % k;
            if (!remainderMap.containsKey(remainder)) {
                remainderMap.put(remainder, i);
            } else if (i - remainderMap.get(remainder) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 23, 2, 4, 6, 7 },
                { 23, 2, 6, 4, 7 },
                { 23, 2, 6, 4, 7 },
                { 5, 0, 0, 0 },
                { 1, 0 },
                { 0, 0 },
        };
        int[] ks = { 6, 6, 13, 3, 2, 1 };
        boolean[] exps = { true, true, false, true, false, true };

        String[] labels = { "checkSubarraySum1 (brute force)", "checkSubarraySum2 (prefix sum + hashmap)" };
        for (int approach = 0; approach < 2; approach++) {
            System.out.println("--- " + labels[approach] + " ---");
            for (int i = 0; i < nums.length; i++) {
                boolean result = approach == 0
                        ? checkSubarraySum1(nums[i], ks[i])
                        : checkSubarraySum2(nums[i], ks[i]);
                boolean pass = result == exps[i];
                System.out.println("[" + (pass ? "PASS" : "FAIL") + "] result=" + result + " expected=" + exps[i]);
            }
        }
    }
}
