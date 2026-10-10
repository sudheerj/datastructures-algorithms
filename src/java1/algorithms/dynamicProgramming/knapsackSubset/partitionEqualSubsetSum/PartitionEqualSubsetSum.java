package java1.algorithms.dynamicProgramming.knapsackSubset.partitionEqualSubsetSum;

public class PartitionEqualSubsetSum {
    // 0/1 Knapsack: TC: O(n * target) SC: O(target)
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[][] tests = {
                { 1, 5, 11, 5 },
                { 1, 2, 3, 5 },
                { 2, 2, 1, 1 },
                { 1 },
                { 0, 0 },
                { 3, 3, 3, 4, 5 }
        };
        boolean[] expected = { true, false, true, false, true, true };
        String[] labels = {
                "Example 1: equal partition exists",
                "Example 2: odd total",
                "Example 3: duplicate values",
                "single element",
                "all zeros",
                "Example 4: subset sum target"
        };

        for (int i = 0; i < tests.length; i++) {
            boolean actual = canPartition(tests[i]);
            System.out.println("[" + (actual == expected[i] ? "PASS" : "FAIL") + "] "
                    + labels[i] + ": " + actual + " (expected " + expected[i] + ")");
        }
    }
}
