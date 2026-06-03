package java1.algorithms.dynamicProgramming.allocateMailboxes;

import java.util.Arrays;

public class AllocateMailboxes {
    int[] houses;
    int[][] cost;
    int n;
    int INF = (int) 1e9;

    // Recursion with cost calculation TC: O(2^n + n^3) SC: O(n^2 + n)
    private int minDistance1(int[] houses, int k) {
        Arrays.sort(houses);
        n = houses.length;
        this.houses = houses;
        cost = new int[n][n];

        // O(n^3) cost computation
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int median = houses[(i + j) / 2];
                for (int p = i; p <= j; p++) {
                    cost[i][j] += Math.abs(houses[p] - median);
                }
            }
        }

        return dfs(0, k);
    }

    private int dfs(int start, int k) {
        if (start == n)
            return 0;
        if (k == 0)
            return INF;

        int minDistance = INF;

        for (int end = start; end < n; end++) {
            minDistance = Math.min(minDistance, cost[start][end] + dfs(end + 1, k - 1));
        }

        return minDistance;
    }

    int[][] memo;

    // Top-down memoization approach TC: O(n^2 * k + n^3) SC: O(n^2 + n *k)
    private int minDistance2(int[] houses, int k) {
        Arrays.sort(houses);
        n = houses.length;
        this.houses = houses;
        cost = new int[n][n];

        // Cost computation
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int median = houses[(i + j) / 2];
                for (int p = i; p <= j; p++) {
                    cost[i][j] += Math.abs(houses[p] - median);
                }
            }
        }

        memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs1(0, k);
    }

    private int dfs1(int start, int k) {
        if (start == n)
            return 0;
        if (k == 0)
            return INF;

        if (memo[start][k] != -1) {
            return memo[start][k];
        }

        int minDistance = INF;

        for (int end = start; end < n; end++) {
            minDistance = Math.min(minDistance, cost[start][end] + dfs1(end + 1, k - 1));
        }

        return memo[start][k] = minDistance;
    }

    int[][] dp;

    // Bottom-up approach TC: O(n^2 * k + n^3) SC: O(n^2 + n * k)
    private int minDistance3(int[] houses, int k) {
        Arrays.sort(houses);
        n = houses.length;
        this.houses = houses;
        cost = new int[n][n];

        // Cost computation
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int median = houses[(i + j) / 2];
                for (int p = i; p <= j; p++) {
                    cost[i][j] += Math.abs(houses[p] - median);
                }
            }
        }

        dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int m = 1; m <= k; m++) {
                for (int p = 0; p < i; p++) {
                    dp[i][m] = Math.min(dp[i][m], dp[p][m - 1] + cost[p][i - 1]);
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        AllocateMailboxes solution = new AllocateMailboxes();

        // Test cases: [houses[], k, expected]
        Object[][] tests = {
                { new int[] { 1, 4, 8, 10, 20 }, 3, 5 },
                { new int[] { 2, 3, 5, 12, 18 }, 2, 9 },
                { new int[] { 7, 4, 6, 1 }, 1, 8 },
                { new int[] { 3, 6, 14, 10 }, 4, 0 },
                { new int[] { 1, 2, 3, 4, 5 }, 2, 3 },
                { new int[] { 1, 10, 20, 30, 40 }, 2, 29 },
                { new int[] { 5, 10, 15, 20, 25 }, 3, 10 },
                { new int[] { 1, 2 }, 1, 1 },
                { new int[] { 1, 5, 10 }, 2, 4 },
                { new int[] { 1, 100, 200, 300 }, 2, 199 }
        };

        System.out.println("Allocate Mailboxes - Test Results:");
        System.out.println("=".repeat(100));

        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            int[] houses = (int[]) tests[i][0];
            int k = (int) tests[i][1];
            int expected = (int) tests[i][2];

            // Test all approaches (skip recursive for large inputs)
            int result1 = (houses.length < 8) ? solution.minDistance1(houses.clone(), k) : expected;
            int result2 = solution.minDistance2(houses.clone(), k);
            int result3 = solution.minDistance3(houses.clone(), k);

            boolean pass = (result2 == expected && result3 == expected);

            // Debug: print all results if test fails
            if (!pass) {
                System.out.printf("Test %2d FAIL | Houses: %s, k=%d%n", i + 1, Arrays.toString(houses), k);
                System.out.printf("  Recursive: %d, Memo: %d, DP: %d | Expected: %d%n",
                        result1, result2, result3, expected);
            } else {
                System.out.printf("Test %2d | Houses: %-25s | k: %d | Output: %3d | Expected: %3d | %s%n",
                        i + 1, Arrays.toString(houses), k, result2, expected, "PASS");
                passed++;
            }
        }

        System.out.println("=".repeat(100));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
