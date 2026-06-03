package java1.algorithms.dynamicProgramming.buySellStock3;

import java.util.Arrays;

public class BuySellStock3 {
    // Recursive TC: O(2^n) SC: O(n)(recursion stack)
    private int maxProfit1(int[] prices) {
        // dfs(day, buy/sell, cap transactions)
        return dfs(0, 1, 2, prices);
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

    // Top-down memoization DP TC: O(n * 2 * 3) SC: O(n * 2 * 3) + O(n)(recursion
    // stack)
    private int maxProfit2(int[] prices) {
        int n = prices.length;
        dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs1(0, 1, 2, prices);
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

    // Bottom-up tabulation DP TC: O(n * 2 * 3) SC: O(n * 2 * 3)
    private int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap]);
                    } else {
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i + 1][1][cap - 1], dp[i + 1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }

    // DP Space optimized version TC: O(n * 2 * 3) SC: O(2 * 3)
    private int maxProfit4(int[] prices) {
        int[][] next = new int[2][3];

        for (int i = prices.length - 1; i >= 0; i--) {
            int[][] curr = new int[2][3];
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        curr[buy][cap] = Math.max(-prices[i] + next[0][cap], next[1][cap]);
                    } else {
                        curr[buy][cap] = Math.max(prices[i] + next[1][cap - 1], next[0][cap]);
                    }
                }
            }
            next = curr;
        }

        return next[1][2];
    }

    // 4-state machine variables(buy1->sell1->buy2->sell2) TC: O(n) SC: O(1)
    private int maxProfit5(int[] prices) {
        int n = prices.length;
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);

            sell1 = Math.max(sell1, buy1 + price);

            buy2 = Math.max(buy2, sell1 - price);

            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }

    public static void main(String[] args) {
        BuySellStock3 solution = new BuySellStock3();

        int[][][] tests = {
                { { 3, 3, 5, 0, 0, 3, 1, 4 }, { 6 } }, // Buy on day 4, sell on day 6, buy on day 7, sell on day 8
                { { 1, 2, 3, 4, 5 }, { 4 } }, // Buy on day 1, sell on day 5
                { { 7, 6, 4, 3, 1 }, { 0 } }, // No transaction
                { { 1 }, { 0 } }, // Single day, no transaction
                { { 1, 2 }, { 1 } }, // Buy day 1, sell day 2
                { { 2, 1, 2, 0, 1 }, { 2 } }, // Buy day 2, sell day 3, buy day 4, sell day 5
                { { 3, 2, 6, 5, 0, 3 }, { 7 } }, // Buy day 2, sell day 3, buy day 5, sell day 6
                { { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }, { 13 } }, // Multiple peaks
                { { 6, 1, 3, 2, 4, 7 }, { 7 } }, // Buy day 2, sell day 6
                { { 5, 4, 3, 2, 1, 6 }, { 5 } } // Buy day 5, sell day 6
        };

        System.out.println("Buy and Sell Stock III - Test Results:");
        System.out.println("=".repeat(90));

        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            int[] prices = tests[i][0];
            int expected = tests[i][1][0];

            // Test all 5 approaches
            int result1 = solution.maxProfit1(prices);
            int result2 = solution.maxProfit2(prices);
            int result3 = solution.maxProfit3(prices);
            int result4 = solution.maxProfit4(prices);
            int result5 = solution.maxProfit5(prices);

            boolean pass = (result1 == expected && result2 == expected &&
                    result3 == expected && result4 == expected && result5 == expected);

            if (pass)
                passed++;

            String pricesStr = Arrays.toString(prices);
            if (pricesStr.length() > 30) {
                pricesStr = pricesStr.substring(0, 27) + "...]";
            }

            // Debug: print all results if test fails
            if (!pass) {
                System.out.printf("Test %2d FAIL | Prices: %s%n", i + 1, Arrays.toString(prices));
                System.out.printf(
                        "  Recursive: %d, Memo: %d, Tabulation: %d, Space-opt: %d, State-machine: %d | Expected: %d%n",
                        result1, result2, result3, result4, result5, expected);
            } else {
                System.out.printf("Test %2d | Prices: %-30s | Output: %2d | Expected: %2d | %s%n",
                        i + 1, pricesStr, result5, expected, pass ? "PASS" : "FAIL");
            }
        }

        System.out.println("=".repeat(90));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
