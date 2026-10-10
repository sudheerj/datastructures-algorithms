package java1.algorithms.dynamicProgramming.partition.maximumNonDecreasingArrayLength;

public class MaximumNonDecreasingArrayLength {
    // Prefix sums + DP + binary search: TC O(n log n), SC O(n).
    // Assumes nums contains positive values so prefix sums are sorted.
    public static int maxNonDecreasingArrayLength(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] dp = new int[n + 1];

        // best[i] carries the furthest valid previous boundary available at i.
        int[] best = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            best[i] = Math.max(best[i], best[i - 1]);

            int j = best[i];
            dp[i] = dp[j] + 1;

            long target = 2L * prefix[i] - prefix[j];

            int k = lowerbound(prefix, target);
            if (k <= n) {
                best[k] = Math.max(best[k], i);
            }

        }

        return dp[n];
    }

    public static int lowerbound(long[] prefix, long target) {
        int left = 0;
        int right = prefix.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            { 5, 2, 2 },
            { 1, 2, 3, 4 },
            { 4, 3, 2, 6 },
            { 7 },
            { 1, 1, 1 },
            { 1, 2, 3, 4, 5 },
            { 3, 1, 1, 2 }
        };
        int[] expected = { 1, 4, 3, 1, 2, 5, 2 };
        String[] labels = {
            "cannot split into multiple valid groups",
            "already non-decreasing singleton groups",
            "merge adjacent values to keep sums non-decreasing",
            "single element",
            "duplicate values",
            "strictly increasing values",
            "small first group followed by merged groups"
        };

        for (int i = 0; i < testCases.length; i++) {
            int actual = maxNonDecreasingArrayLength(testCases[i]);
            System.out.println("[" + (actual == expected[i] ? "PASS" : "FAIL") + "] "
                + labels[i] + ": " + actual + " (expected " + expected[i] + ")");
        }
    }
}
