package java1.algorithms.dynamicProgramming.minFallingPathSum;

import java.util.Arrays;

public class MinFallingPathSum {
    //Top-down DP memoization TC: O(n^2) SC: O(n^2)
    private static int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        int[][] cache = new int[n][n];
        for(int r=0; r<n; r++) {
            Arrays.fill(cache[r], Integer.MIN_VALUE);
        } 
        int minSum = Integer.MAX_VALUE;

        for(int c=0; c<n; c++) {
            minSum = Math.min(minSum, dfs(0, c, matrix, cache, n));
        }

        return minSum;
    }

    private static int dfs(int r, int c, int[][] matrix, int[][] cache, int n) {
        if(r == n) return 0;
        if(c <0 || c>=n) return Integer.MAX_VALUE;

        if(cache[r][c] != Integer.MIN_VALUE) {
            return cache[r][c];
        }

        return cache[r][c] = matrix[r][c] + Math.min(Math.min(dfs(r+1, c-1, matrix, cache, n), dfs(r+1, c, matrix, cache, n)), dfs(r+1, c+1, matrix, cache, n));
    }

    //Bottom-up inplace TC: O(n^2) SC: O(1)
    private static int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        for(int r=1; r< n; r++) {
            for(int c=0; c<n; c++) {
                int mid = matrix[r-1][c];
                int left = c>0 ? matrix[r-1][c-1] : Integer.MAX_VALUE;
                int right = c<n-1 ? matrix[r-1][c+1] : Integer.MAX_VALUE;
                matrix[r][c] = matrix[r][c] + Math.min(Math.min(left, mid), right);
            }
        }

        int minResult = Integer.MAX_VALUE;
        for(int c=0; c<n; c++) {
            minResult = Math.min(minResult, matrix[n-1][c]);
        }

        return minResult;
    }

    private static int[][] copyMatrix(int[][] m) {
        int[][] copy = new int[m.length][];
        for (int i = 0; i < m.length; i++) copy[i] = m[i].clone();
        return copy;
    }

    public static void main(String[] args) {
        int[][][] rawTests = {
            {{2,1,3},{6,5,4},{7,8,9}},
            {{-19,57},{-40,-5}},
            {{1}},
            {{1,2,3},{4,5,6},{7,8,9}},
            {{-1,-2},{-3,-4}}
        };
        int[] expected = {13, -59, 1, 12, -6};
        String[] labels = {"3x3 standard", "2x2 negative", "single cell", "3x3 ascending", "2x2 all negative"};

        System.out.println("=== Approach 1: Top-down Memoization ===");
        for (int i = 0; i < rawTests.length; i++) {
            int result = minFallingPathSum1(copyMatrix(rawTests[i]));
            System.out.println("[" + (result == expected[i] ? "PASS" : "FAIL") + "] " + labels[i] + ": " + result + "  (expected " + expected[i] + ")");
        }

        System.out.println("=== Approach 2: Bottom-up In-place ===");
        for (int i = 0; i < rawTests.length; i++) {
            int result = minFallingPathSum2(copyMatrix(rawTests[i]));
            System.out.println("[" + (result == expected[i] ? "PASS" : "FAIL") + "] " + labels[i] + ": " + result + "  (expected " + expected[i] + ")");
        }
    }
}
