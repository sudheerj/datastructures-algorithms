package java1.algorithms.dynamicProgramming.minimumPathSum;

import java.util.Arrays;

public class MinimumPathSum {
    //Top down memoization TC: O(m*n) SC: O(m*n)
    private static int minPathSum1(int[][] grid) {
        int rows= grid.length, cols = grid[0].length;
        Integer[][] memo = new Integer[rows][cols];
        
        return dfs(grid, 0,0, memo);
    }

    private static int dfs(int[][] grid, int r, int c, Integer[][] memo) {
        //out of bounds
        if(r >= grid.length || c>= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        //reached target
        if(r == grid.length-1 && c== grid[0].length-1) {
            return grid[r][c];
        }

        if(memo[r][c] != null) {
            return memo[r][c];
        }

        int down = dfs(grid, r+1, c, memo);
        int right = dfs(grid, r, c+1, memo);

        return memo[r][c] = grid[r][c] + Math.min(down, right);
    }

    //Bottom-up DP TC: O(m * n) SC: O(m * n)
    private static int minPathSum2(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[][] dp = new int[rows+1][cols+1];

        for(int r=0; r<=rows; r++) {
            for(int c=0; c<=cols; c++) {
                dp[r][c] = Integer.MAX_VALUE;
            }
        }

        dp[rows][cols-1] = 0;

        for(int r=rows-1; r>=0; r--) {
            for(int c=cols-1; c>=0; c--) {
                dp[r][c] = grid[r][c] + Math.min(dp[r+1][c], dp[r][c+1]);
            }
        }

        return dp[0][0];
    }

    //Bottom-up optimized(two variables) TC: O(m * n) SC: O(1)
    private static int maxPathSum3(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] dp = new int[cols+1];
        for(int c=0; c<=cols; c++) {
            dp[c] = Integer.MAX_VALUE;
        }

        dp[cols-1] = 0;

        for(int r=rows-1; r>=0; r--) {
            for(int c=cols-1; c>=0; c--) {
                dp[c] = grid[r][c] + Math.min(dp[c], dp[c+1]);
            }
        }

        return dp[0];
    }

    private static String pass(boolean ok) { return ok ? "PASS" : "FAIL"; }

    public static void main(String[] args) {
        int[][][][] tests = {
            {{{1,3,1},{1,5,1},{4,2,1}}, {{7}}},
            {{{1,2,3},{4,5,6}},         {{12}}},
            {{{1}},                     {{1}}},
            {{{1,2},{1,1}},             {{3}}},
            {{{5,1,2},{3,6,4},{1,8,1}}, {{13}}}
        };
        String[] labels = {
            "3x3 standard",
            "2x3 grid",
            "single cell",
            "2x2 grid",
            "3x3 off-diagonal min"
        };

        System.out.println("=== Top-down (Memoization) ===");
        for (int i = 0; i < tests.length; i++) {
            int result = minPathSum1(tests[i][0]);
            int expected = tests[i][1][0][0];
            System.out.println("  [" + pass(result == expected) + "] " + labels[i]
                + ": " + result + "  (expected " + expected + ")");
        }

        System.out.println("=== Bottom-up DP ===");
        for (int i = 0; i < tests.length; i++) {
            int result = minPathSum2(tests[i][0]);
            int expected = tests[i][1][0][0];
            System.out.println("  [" + pass(result == expected) + "] " + labels[i]
                + ": " + result + "  (expected " + expected + ")");
        }

        System.out.println("=== Space-Optimized DP ===");
        for (int i = 0; i < tests.length; i++) {
            int result = maxPathSum3(tests[i][0]);
            int expected = tests[i][1][0][0];
            System.out.println("  [" + pass(result == expected) + "] " + labels[i]
                + ": " + result + "  (expected " + expected + ")");
        }
    }
}
