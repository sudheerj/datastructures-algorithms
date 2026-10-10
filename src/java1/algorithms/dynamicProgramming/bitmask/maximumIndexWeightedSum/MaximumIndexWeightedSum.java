package java1.algorithms.dynamicProgramming.bitmask.maximumIndexWeightedSum;

import java.util.Arrays;

public class MaximumIndexWeightedSum {
    // Bitmask DP over positions; each state considers fixing or pairing the first
    // unused index.
    // TC: O(n * 2^n), SC: O(2^n)
    public static long maxIndexWeightedSum(int[] nums) {
        int n = nums.length;
        long originalScore = 0;

        // Start with the score before any swaps. A swap contributes only its score
        // difference.
        for (int i = 0; i < n; i++) {
            originalScore += (long) i * nums[i];
        }

        long[] dp = new long[1 << n];
        Arrays.fill(dp, Long.MIN_VALUE);
        return originalScore + dfs(nums, 0, dp);
    }

    public static long dfs(int[] nums, int mask, long[] dp) {
        int n = nums.length;
        // Every index has been fixed or included in a swap; no more score can be
        // gained.
        if (mask == (1 << n) - 1) {
            return 0;
        }

        // The mask uniquely identifies which indices are no longer available.
        if (dp[mask] != Long.MIN_VALUE) {
            return dp[mask];
        }

        // Process the first unused index. This avoids exploring the same pairings in
        // different orders.
        int i = 0;
        while ((mask & (1 << i)) != 0) {
            i++;
        }

        // Option 1: leave index i where it is and mark it as processed.
        long best = dfs(nums, mask | 1 << i, dp);

        // Option 2: swap i with an unused later index j.
        for (int j = i + 1; j < n; j++) {
            if ((mask & (1 << j)) != 0) {
                continue;
            }

            // Score change is (i*nums[j] + j*nums[i]) - (i*nums[i] + j*nums[j]).
            long gain = (long) (j - i) * (nums[i] - nums[j]);
            int newMask = mask | (1 << i) | (1 << j);
            best = Math.max(best, gain + dfs(nums, newMask, dp));
        }

        dp[mask] = best;
        return best;
    }

    public static void main(String[] args) {
        int[][] tests = {
                { 3, 1, 2 },
                { 1, 3, 2 },
                { 4, 1, 3, 2 },
                { 5, 5, 5 },
                { 7 },
                { 2, 1 }
        };
        long[] expected = { 7, 8, 17, 15, 0, 2 };
        String[] labels = {
                "swap improves score",
                "best single swap",
                "multiple disjoint swaps",
                "equal values",
                "single element",
                "already optimal order"
        };

        for (int test = 0; test < tests.length; test++) {
            long actual = maxIndexWeightedSum(tests[test]);
            System.out.println("[" + (actual == expected[test] ? "PASS" : "FAIL") + "] "
                    + labels[test] + ": " + actual + " (expected " + expected[test] + ")");
        }
    }
}
