package java1.algorithms.dynamicProgramming.triangle;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    //Top-down memoization TC: O(n^2) SC: O(n^2)
    private static int triangle1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][];

        for(int r=0; r<n; r++) {
            memo[r] = new int[triangle.get(r).size()];
            Arrays.fill(memo[r], Integer.MAX_VALUE);
        }

        return dfs(triangle, 0, 0, memo);
    }

    private static int dfs(List<List<Integer>> triangle, int r, int c, int[][] memo) {
        if(r >= triangle.size()) return 0;

        if(memo[r][c] != Integer.MAX_VALUE) {
            return memo[r][c];
        }

        return memo[r][c] = triangle.get(r).get(c) + Math.min(dfs(triangle, r+1, c, memo), dfs(triangle, r+1, c+1, memo));
    }

    //Bottom-up DP Array TC: O(n^2) SC: O(n^2)
    private static int triangle2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        //Dp last rows will have same values as triangle last row
        for(int c=0; c<triangle.get(n-1).size(); c++) {
            dp[n-1][c] = triangle.get(n-1).get(c);
        }

        for(int r=n-2; r>=0; r--) {
            for(int c=0; c<triangle.get(r).size(); c++) {
                dp[r][c] = triangle.get(r).get(c) + Math.min(dp[r+1][c], dp[r+1][c+1]);
            }
        }

        return dp[0][0];
    }

    //Bottom-up In-place TC:O(n^2) SC: O(1)
    private static int triangle3(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int r=n-2; r>=0; r--) {
            for(int c=0; c<triangle.get(r).size(); c++) {
                triangle.get(r).set(c, triangle.get(r).get(c) + Math.min(triangle.get(r+1).get(c), triangle.get(r+1).get(c+1)));
            }
        }

        return triangle.get(0).get(0);
    }

    private static List<List<Integer>> makeTriangle(int[][] rows) {
        List<List<Integer>> t = new java.util.ArrayList<>();
        for (int[] row : rows) {
            List<Integer> r = new java.util.ArrayList<>();
            for (int v : row) r.add(v);
            t.add(r);
        }
        return t;
    }

    public static void main(String[] args) {
        int[][][] rawTests = {
            {{2},{3,4},{6,5,7},{4,1,8,3}},
            {{-10}},
            {{1},{2,3}},
            {{-1},{2,3},{1,-1,-3}},
            {{1},{2,3},{4,5,6},{7,8,9,10}}
        };
        int[] expected = {11, -10, 3, -1, 14};
        String[] labels = {"standard 4-row", "single negative", "2-row", "negative values", "4-row ascending"};

        System.out.println("=== Approach 1: Top-down Memoization ===");
        for (int i = 0; i < rawTests.length; i++) {
            int result = triangle1(makeTriangle(rawTests[i]));
            System.out.println("[" + (result == expected[i] ? "PASS" : "FAIL") + "] " + labels[i] + ": " + result + "  (expected " + expected[i] + ")");
        }

        System.out.println("=== Approach 2: Bottom-up DP ===");
        for (int i = 0; i < rawTests.length; i++) {
            int result = triangle2(makeTriangle(rawTests[i]));
            System.out.println("[" + (result == expected[i] ? "PASS" : "FAIL") + "] " + labels[i] + ": " + result + "  (expected " + expected[i] + ")");
        }

        System.out.println("=== Approach 3: In-place ===");
        for (int i = 0; i < rawTests.length; i++) {
            int result = triangle3(makeTriangle(rawTests[i]));
            System.out.println("[" + (result == expected[i] ? "PASS" : "FAIL") + "] " + labels[i] + ": " + result + "  (expected " + expected[i] + ")");
        }
    }
}
