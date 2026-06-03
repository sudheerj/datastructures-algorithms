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

    //Bottom-up DP Array(reversal) TC: O(n^2) SC: O(n^2)
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

    //Bottom-up space optimized TC: O(n^2) SC: O(n)
    private static int  triangle3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        //initialize with last row
        for(int i=0; i<n; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }

        for(int r=n-2; r>=0; r--) {
            for(int c=0; c<triangle.get(r).size(); c++) {
                dp[c] = triangle.get(r).get(c) + Math.min(dp[c], dp[c+1]);
            }
        }

        return dp[0];
    }
    //Bottom-up In-place TC:O(n^2) SC: O(1)
    private static int triangle4(List<List<Integer>> triangle) {
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

    private static String triangleToString(int[][] triangle) {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < triangle.length; i++) {
            sb.append(Arrays.toString(triangle[i]));
            if(i < triangle.length - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases: [triangle, expected]
        Object[][] tests = {
            {new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}}, 11},
            {new int[][]{{-10}}, -10},
            {new int[][]{{1},{2,3}}, 3},
            {new int[][]{{-1},{2,3},{1,-1,-3}}, -1},
            {new int[][]{{1},{2,3},{4,5,6},{7,8,9,10}}, 14},
            {new int[][]{{-1},{-2,-3}}, -4},
            {new int[][]{{5},{-3,2},{1,4,-1},{-2,3,1,0}}, 1},
            {new int[][]{{1},{1,1},{1,1,1}}, 3},
            {new int[][]{{10},{9,8},{7,6,5}}, 23},
            {new int[][]{{-5},{-2,-4},{-1,-3,-6},{-8,-9,-10,-11}}, -26}
        };

        System.out.println("Triangle - Test Results:");
        System.out.println("=".repeat(120));

        int passed = 0;
        for(int i = 0; i < tests.length; i++) {
            int[][] triangleArr = (int[][]) tests[i][0];
            int expected = (int) tests[i][1];

            // Test all four approaches
            int result1 = triangle1(makeTriangle(triangleArr));
            int result2 = triangle2(makeTriangle(triangleArr));
            int result3 = triangle3(makeTriangle(triangleArr));
            int result4 = triangle4(makeTriangle(triangleArr));

            boolean pass = (result1 == expected && result2 == expected && 
                           result3 == expected && result4 == expected);

            // Debug: print all results if test fails
            if (!pass) {
                System.out.printf("Test %2d FAIL | Input: %s%n", i + 1, triangleToString(triangleArr));
                System.out.printf("  Memoization: %d, DP: %d, Space-opt: %d, In-place: %d | Expected: %d%n",
                        result1, result2, result3, result4, expected);
            } else {
                System.out.printf("Test %2d | Input: %-50s | Output: %d | Expected: %d | PASS%n",
                        i + 1, triangleToString(triangleArr), result1, expected);
                passed++;
            }
        }

        System.out.println("=".repeat(120));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
