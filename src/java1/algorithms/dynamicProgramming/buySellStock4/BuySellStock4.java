package java1.algorithms.dynamicProgramming.buySellStock4;

import java.util.Arrays;

public class BuySellStock4 {
    // Recursive TC: O(2^n) SC: O(n)(recursion stack)
    private int maxProfit1(int[] prices, int k) {
        // dfs(day, buy/sell, cap transactions)
        return dfs(0, 1, k, prices);
    }

    private int dfs(int idx, int buy, int cap, int[] prices) {
        if (idx == prices.length || cap == 0) {
            return 0;
        }

        if (buy == 1) { // buy or skip
            return Math.max(-prices[idx] + dfs(idx + 1, 0, cap, prices), dfs(idx + 1, 1, cap, prices));
        } else { // sell or hold
            return Math.max(prices[idx] + dfs(idx + 1, 1, cap - 1, prices), dfs(idx + 1, 0, cap, prices));
        }
    }

    int[][][] dp;

    // Top-down memoization DP TC: O(n * 2 * k) SC: O(n * 2 * k) + O(n)(recursion
    // stack)
    private int maxProfit2(int[] prices, int k) {
        int n = prices.length;
        dp = new int[n][2][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs1(0, 1, k, prices);
    }

    private int dfs1(int idx, int buy, int cap, int[] prices) {
        if (idx == prices.length || cap == 0) {
            return 0;
        }

        if (dp[idx][buy][cap] != -1) {
            return dp[idx][buy][cap];
        }

        int maxProfit = 0;

        if (buy == 1) { // buy/skip
            maxProfit = Math.max(-prices[idx] + dfs1(idx + 1, 0, cap, prices), dfs1(idx + 1, 1, cap, prices));
        } else {// sell/hold
            maxProfit = Math.max(prices[idx] + dfs1(idx + 1, 1, cap - 1, prices), dfs1(idx + 1, 0, cap, prices));
        }

        return dp[idx][buy][cap] = maxProfit;
    }

    // Bottom-up tabulation DP TC: O(n * 2 * k) SC: O(n * 2 * k)
    private int maxProfit3(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap]);
                    } else {
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i + 1][1][cap - 1], dp[i + 1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][k];
    }

    // DP Space optimized version TC: O(n * 2 * k) SC: O(2 * k)
    private int maxProfit4(int[] prices, int k) {
        int[][] next = new int[2][k + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            int[][] curr = new int[2][k + 1];
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        curr[buy][cap] = Math.max(-prices[i] + next[0][cap], next[1][cap]);
                    } else {
                        curr[buy][cap] = Math.max(prices[i] + next[1][cap - 1], next[0][cap]);
                    }
                }
            }
            next = curr;
        }

        return next[1][k];
    }

    // Greedy + DP Space optimized for large k TC: O(n * 2 * k) or O(n) SC: O(k) or
    // O(1)
    private int maxProfit5(int[] prices, int k) {
        int n = prices.length;
        // If k >= n/2, we can do unlimited transactions (greedy approach)
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        // Otherwise, use space-optimized DP
        return maxProfit4(prices, k);
    }

    public static void main(String[] args) {
        BuySellStock4 solution = new BuySellStock4();

        // Test cases: [k, prices[], expected]
        Object[][] tests = {
                { 2, new int[] { 2, 4, 1 }, 2 }, // Buy day 1, sell day 2
                { 2, new int[] { 3, 2, 6, 5, 0, 3 }, 7 }, // Buy day 2, sell day 3, buy day 5, sell day 6
                { 2, new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }, 6 }, // Two transactions
                { 2, new int[] { 1, 2, 3, 4, 5 }, 4 }, // One transaction
                { 2, new int[] { 7, 6, 4, 3, 1 }, 0 }, // No transaction
                { 3, new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }, 15 }, // Three transactions
                { 1, new int[] { 1, 2, 3, 4, 5 }, 4 }, // One transaction allowed
                { 4, new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }, 15 }, // Multiple transactions
                { 2, new int[] { 6, 1, 3, 2, 4, 7 }, 7 }, // Buy day 2, sell day 6
                { 3, new int[] { 5, 4, 3, 2, 1, 6, 7 }, 6 } // Buy day 5, sell day 7
        };

        System.out.println("Buy and Sell Stock IV - Test Results:");
        System.out.println("=".repeat(90));

        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            int k = (int) tests[i][0];
            int[] prices = (int[]) tests[i][1];
            int expected = (int) tests[i][2];

            // Test all 5 approaches
            int result1 = solution.maxProfit1(prices, k);
            int result2 = solution.maxProfit2(prices, k);
            int result3 = solution.maxProfit3(prices, k);
            int result4 = solution.maxProfit4(prices, k);
            int result5 = solution.maxProfit5(prices, k);

            boolean pass = (result1 == expected && result2 == expected &&
                    result3 == expected && result4 == expected && result5 == expected);

            if (pass)
                passed++;

            String pricesStr = Arrays.toString(prices);
            if (pricesStr.length() > 25) {
                pricesStr = pricesStr.substring(0, 22) + "...]";
            }

            // Debug: print all results if test fails
            if (!pass) {
                System.out.printf("Test %2d FAIL | k=%d, Prices: %s%n", i + 1, k, Arrays.toString(prices));
                System.out.printf(
                        "  Recursive: %d, Memo: %d, Tabulation: %d, Space-opt: %d, Greedy+DP: %d | Expected: %d%n",
                        result1, result2, result3, result4, result5, expected);
            } else {
                System.out.printf("Test %2d | k=%d | Prices: %-25s | Output: %2d | Expected: %2d | %s%n",
                        i + 1, k, pricesStr, result4, expected, pass ? "PASS" : "FAIL");
            }
        }

        System.out.println("=".repeat(90));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
