package java1.algorithms.dynamicProgramming.fibonacciNumber;

import java.util.Arrays;

public class FibonacciNumber {
    //Brute force - Recursion TC: O(2^n) SC: O(n)
    private static int fibonacci1(int n) {
        if(n <=1) {
            return n;
        }

        return fibonacci1(n -1) + fibonacci1(n -2);
    }

    //Memoization(Top-down DP)  TC: O(n) SC: O(n)
    private static int fibonacci2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return calc(n, dp); 
    }

    private static int calc(int n, int[] dp) {
        if(n <=1) return n;

        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = calc(n-1, dp) + calc(n-2, dp);

        return dp[n];
    }

    //Tabulation(Bottom-up DP) TC: O(n) SC: O(n)
    private static int fibonacci3(int n) {
        if(n <= 1) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    //DP Space optimized two variables TC: O(n) SC: O(1)
    private static int fibonacci4(int n) {
        if(n <=1) {
            return n;
        }

        int first = 0;
        int second = 1;

        for(int i=2; i<=n; i++) {
            int curr = first + second;
            first = second;
            second = curr;
        }

        return second;
    }

    private static String pass(boolean ok) { return ok ? "PASS" : "FAIL"; }

    public static void main(String[] args) {
        int[][] tests = {{0,0},{1,1},{2,1},{3,2},{5,5},{10,55}};
        String[] labels = {"n=0","n=1","n=2","n=3","n=5","n=10"};
        String[] methods = {"Recursive","Memoization","Tabulation","Space-Opt"};

        for (int m = 0; m < 4; m++) {
            System.out.println("=== " + methods[m] + " ===");
            for (int i = 0; i < tests.length; i++) {
                int n = tests[i][0], expected = tests[i][1];
                int result = switch (m) {
                    case 0 -> fibonacci1(n);
                    case 1 -> fibonacci2(n);
                    case 2 -> fibonacci3(n);
                    default -> fibonacci4(n);
                };
                System.out.println("  [" + pass(result == expected) + "] " + labels[i]
                    + ": " + result + "  (expected " + expected + ")");
            }
        }
    }
}
