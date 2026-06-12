package java1.algorithms.dynamicProgramming.burstBallons;

import java.util.Arrays;

public class BurstBallons {
    //Top-down memoization TC: O(n^3) SC: O(n^2)
    private int maxCoins1(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;

        for(int i=0; i<n; i++) {
            newNums[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return dfs(newNums, 1, n-1, dp);
    }

    private int dfs(int[] nums, int left, int right, int[][] dp) {
        if(left>right) {
            return 0;
        }

        if(dp[left][right] != -1) {
            return dp[left][right];
        }

        dp[left][right] = 0;

        for(int i=left; i<=right; i++) {
            int coins = nums[i-1] * nums[i] * nums[i+1];
            coins += dfs(nums, left, i-1, dp) + dfs(nums, i+1, right, dp);
            dp[left][right] = Math.max(dp[left][right], coins);
        }

        return dp[left][right];
    }
    //Bottom-up DP TC: O(n^3) SC: O(n^2)
    private int maxCoins2(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;

        for(int i=0; i<n; i++) {
            newNums[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];

        for(int left=n; left>=1; left--) {
            for(int right=1; right<=n; right++) {
                for(int i=left; i<=right; i++) {
                    int coins = nums[i-1] * nums[i] * nums[i+1];
                    coins += dp[left][i-1] + dp[left+1][i];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[1][n];
    }
}
