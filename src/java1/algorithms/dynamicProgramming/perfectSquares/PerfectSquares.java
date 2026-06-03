package java1.algorithms.dynamicProgramming.perfectSquares;

import java.util.Arrays;

public class PerfectSquares {
    //Bottom-up DP(similar to coin change)TC: O(n * sqr(n)) SC: O(n)
    private static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for(int target = 1; target<=n; target++) {
            for(int s=1; s*s <=target; s++) {
                dp[target] = Math.min(dp[target], 1 + dp[target - s* s]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[][] tests = {
            {12, 3},     // 12 = 4 + 4 + 4 (3 squares)
            {13, 2},     // 13 = 4 + 9 (2 squares)
            {1, 1},      // 1 = 1 (1 square)
            {2, 2},      // 2 = 1 + 1 (2 squares)
            {3, 3},      // 3 = 1 + 1 + 1 (3 squares)
            {4, 1},      // 4 = 4 (1 square)
            {7, 4},      // 7 = 4 + 1 + 1 + 1 (4 squares)
            {10, 2},     // 10 = 9 + 1 (2 squares)
            {25, 1},     // 25 = 25 (1 square)
            {26, 2}      // 26 = 25 + 1 (2 squares)
        };

        System.out.println("Perfect Squares - Test Results:");
        System.out.println("=".repeat(50));
        
        int passed = 0;
        for(int i = 0; i < tests.length; i++) {
            int n = tests[i][0];
            int expected = tests[i][1];
            int result = numSquares(n);
            boolean pass = result == expected;
            
            if(pass) passed++;
            
            System.out.printf("Test %2d | Input: %2d | Output: %d | Expected: %d | %s%n",
                i+1, n, result, expected, pass ? "PASS" : "FAIL");
        }
        
        System.out.println("=".repeat(50));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
