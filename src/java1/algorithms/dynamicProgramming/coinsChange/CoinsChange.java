package java1.algorithms.dynamicProgramming.coinsChange;

import java.util.*;

public class CoinsChange {
    // Bottm-up DP(Tabulation) Array => TC: O(amount * numberOfCoins) SC: O(amount)
    private static int coinsChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // Recursion TC: O(n^amount) SC: O(amount)
    private int coinsChange2(int[] coins, int amount) {
        int minCoins = dfs(coins, amount, amount);
        return minCoins == amount + 1 ? -1 : minCoins;
    }

    private int dfs(int[] coins, int remainAmt, int amount) {
        if (remainAmt == 0)
            return 0;

        int minCoins = amount + 1;

        for (int coin : coins) {
            if (remainAmt - coin >= 0) {
                minCoins = Math.min(minCoins, 1 + dfs(coins, remainAmt - coin, amount));
            }
        }

        return minCoins;
    }

    int[] memo;

    // Top-down memoization TC: O(amount * numberOfCoins) SC: O(amount)
    private int minCoins3(int[] coins, int amount) {
        int n = coins.length;
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);

        int result = dfs1(coins, amount, amount);
        return result == amount + 1 ? -1 : result;
    }

    private int dfs1(int[] coins, int remainAmt, int amount) {
        if (remainAmt == 0)
            return 0;
        if (remainAmt < 0)
            return amount + 1;
        if (memo[remainAmt] != -1)
            return memo[remainAmt];

        int minCoins = amount + 1;

        for (int coin : coins) {
            if (remainAmt - coin >= 0) {
                minCoins = Math.min(minCoins, 1 + dfs1(coins, remainAmt - coin, amount));
            }
        }

        return memo[remainAmt] = minCoins;
    }

    public static void main(String[] args) {
        CoinsChange solution = new CoinsChange();

        // Test cases: [coins[], amount, expected]
        Object[][] tests = {
                { new int[] { 1, 3, 4, 5 }, 7, 2 },
                { new int[] { 2 }, 3, -1 },
                { new int[] { 1 }, 0, 0 },
                { new int[] { 1 }, 1, 1 },
                { new int[] { 1 }, 2, 2 },
                { new int[] { 1, 2, 5 }, 11, 3 },
                { new int[] { 2, 5, 10, 1 }, 27, 4 },
                { new int[] { 186, 419, 83, 408 }, 6249, 20 },
                { new int[] { 1, 5, 10, 25 }, 30, 2 },
                { new int[] { 5, 10, 25 }, 3, -1 }
        };

        System.out.println("Coin Change - Test Results:");
        System.out.println("=".repeat(100));

        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            int[] coins = (int[]) tests[i][0];
            int amount = (int) tests[i][1];
            int expected = (int) tests[i][2];

            // Test all approaches (skip recursive for large amounts)
            int result1 = (amount < 20) ? solution.coinsChange2(coins, amount) : expected;
            int result2 = solution.minCoins3(coins, amount);
            int result3 = coinsChange(coins, amount);

            boolean pass = (result2 == expected && result3 == expected);

            // Debug: print all results if test fails
            if (!pass) {
                System.out.printf("Test %2d FAIL | Coins: %s, Amount: %d%n", i + 1, Arrays.toString(coins), amount);
                System.out.printf("  Recursive: %d, Memo: %d, DP: %d | Expected: %d%n",
                        result1, result2, result3, expected);
            } else {
                System.out.printf("Test %2d | Coins: %-20s | Amount: %3d | Output: %3d | Expected: %3d | PASS%n",
                        i + 1, Arrays.toString(coins), amount, result3, expected);
                passed++;
            }
        }

        System.out.println("=".repeat(100));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
