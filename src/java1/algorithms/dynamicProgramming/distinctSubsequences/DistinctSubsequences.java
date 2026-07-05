package java1.algorithms.dynamicProgramming.distinctSubsequences;

public class DistinctSubsequences {
    //2D dynamic programming TC: O(m * n) SC: O(m * n)
    private static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        int[][] dp = new int[m+1][n+1];

        //Empty target
        for(int i=0; i<=m; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return (int)dp[m][n];
    }

    //1D dynamic programming TC: O(m * n) SC: O(n)
    private static int numDistinctOptimized(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[] dp = new int[n+1];

        //Empty target
        dp[0] = 1;

        for(int i=1; i<=m; i++) {
            for(int j=n; j>=1; j--) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] += dp[j-1];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        String[][] tests = {
            {"rabbbit", "rabbit"},   // 3
            {"babgbag", "bag"},      // 5
            {"abc", "abc"},          // 1
            {"abc", "ac"},           // 1
            {"abc", "abcabc"},       // 0
            {"aaa", "aa"},           // 3
            {"aaaaa", "aaa"},        // 10
            {"abcd", "ad"},          // 1
            {"abcd", "abcd"},        // 1
            {"leetcode", "leee"},    // 0
            {"banana", "ban"},       // 3
            {"", ""},                // 1
            {"", "a"},               // 0
            {"a", ""}                // 1
        };

        System.out.println("DISTINCT SUBSEQUENCES TESTS\n");

        for (String[] test : tests) {
            String s = test[0];
            String t = test[1];

            int res2D = numDistinct(s, t);
            int res1D = numDistinctOptimized(s, t);

            System.out.println("s = \"" + s + "\", t = \"" + t + "\"");
            System.out.println("2D DP result : " + res2D);
            System.out.println("1D DP result : " + res1D);
            System.out.println("-----------------------------");
        }
    }
}
