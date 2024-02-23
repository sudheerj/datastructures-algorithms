package java1.algorithms.dynamicProgramming;

public class ClimbingStairs {
    // TC: O(n) SC: O(1)
    private static int climbStairs1(int n) {
        if(n == 1 || n == 2) return 1;

        int first = 1, second = 1, temp;
        for(int i=0; i< n-1; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    // TC:O(n) SC: O(n)
    private static int climbStairs2(int n) {
        if(n == 1 || n == 2) return 1;

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        } 
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(6));
        System.out.println(climbStairs2(6));
    }
}
