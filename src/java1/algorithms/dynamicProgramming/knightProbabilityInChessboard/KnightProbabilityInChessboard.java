package java1.algorithms.dynamicProgramming.knightProbabilityInChessboard;

import java.util.Arrays;

public class KnightProbabilityInChessboard {
    double[][][] memo;
    int[][] DIRS = {{2,1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
    //Top-down memoization TC: O(n^2 * (k+1)) SC: O(n^2 * k)
    private double knightProbability(int n, int k, int r, int c) {
        memo = new double[n][n][k+1];

        for(double[][] board: memo) {
            for(double[] moves: board) {
                Arrays.fill(moves, -1.0);
            }
        }

        return dfs(n, k, r, c);
    }

    private double dfs(int n, int k, int r, int c) {
        if(r < 0 || r >= n || c < 0 || c >= n) return 0.0;

        if(k == 0) return 1.0;

        if(memo[r][c][k] != -1) {
            return memo[r][c][k];
        }

        double prob = 0.0;

        for(int[] dir: DIRS) {
            prob += dfs(n, k-1, r+dir[0], c+dir[1]) / 8.0;
        }

        return memo[r][c][k] = prob;
    }

    double[][] dp;
    //Bottom-up space optimization TC: O(n^2 * k) SC: O(n^2)
    private double knightProbability2(int n, int k, int row, int column) {
        dp = new double[n][n];
        dp[row][column] = 1.0;

        //Find probability on board after each move
        for(int moves = 0; moves < k; moves++) {
            double[][] next = new double[n][n];

            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    if(dp[r][c] == 0) {
                        continue;
                    }

                    for(int[] dir: DIRS) {
                        int nr = r + dir[0], nc = c + dir[1];

                        if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                        next[nr][nc] += dp[r][c] / 8.0;
                    }
                }
            }
            dp = next;
        }

        double probRemain = 0.0;

        for(double[] rowArr: dp) {
            for(double prob: rowArr) {
                probRemain += prob;
            }
        }

        return probRemain;
    }

    public static void main(String[] args) {
        KnightProbabilityInChessboard solution = new KnightProbabilityInChessboard();

        // Test cases: [n, k, row, column, expected]
        Object[][] tests = {
            {3, 2, 0, 0, 0.0625},
            {1, 0, 0, 0, 1.0},
            {8, 30, 6, 4, 0.00019},
            {3, 1, 1, 1, 0.0},
            {8, 0, 4, 4, 1.0},
            {8, 1, 0, 0, 0.25},
            {8, 2, 4, 4, 0.875},
            {5, 2, 2, 2, 0.375},
            {6, 3, 2, 2, 0.359375},
            {4, 3, 1, 1, 0.0703125}
        };

        System.out.println("Knight Probability in Chessboard - Test Results:");
        System.out.println("=".repeat(100));

        int passed = 0;
        for(int i = 0; i < tests.length; i++) {
            int n = (int) tests[i][0];
            int k = (int) tests[i][1];
            int row = (int) tests[i][2];
            int column = (int) tests[i][3];
            double expected = (double) tests[i][4];

            // Test both approaches
            double result1 = solution.knightProbability(n, k, row, column);
            double result2 = solution.knightProbability2(n, k, row, column);

            boolean pass = (Math.abs(result1 - expected) < 1e-5 && Math.abs(result2 - expected) < 1e-5);

            // Debug: print all results if test fails
            if (!pass) {
                System.out.printf("Test %2d FAIL | n=%d, k=%d, pos=(%d,%d)%n", i + 1, n, k, row, column);
                System.out.printf("  Memoization: %.6f, DP: %.6f | Expected: %.6f%n",
                        result1, result2, expected);
            } else {
                System.out.printf("Test %2d | n=%d, k=%2d, pos=(%d,%d) | Output: %.6f | Expected: %.6f | PASS%n",
                        i + 1, n, k, row, column, result1, expected);
                passed++;
            }
        }

        System.out.println("=".repeat(100));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
