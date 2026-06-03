package java1.algorithms.dynamicProgramming.regularExpressionMatching;

public class RegularExpressionMatching {

    static Boolean[][] memo;

    // Top-down memoization TC: O(m*n) SC: O(m *n)
    private static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        memo = new Boolean[m + 1][n + 1];
        return dfs(0, 0, s, p, m, n);
    }

    private static boolean dfs(int i, int j, String s, String p, int m, int n) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (j == n) {
            memo[i][j] = (i == m);
            return memo[i][j];
        }

        boolean result;
        boolean match = (i < m) && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

        if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
            result = dfs(i, j + 2, s, p, m, n) || // skip x*
                    match && dfs(i + 1, j, s, p, m, n); //use x*
        } else {
            result = match && dfs(i + 1, j + 1, s, p, m, n);
        }

        memo[i][j] = result;

        return memo[i][j];
    }

    // Bottom-up approach TC: O(m*n) SC: O(m *n)
    private static boolean isMatch1(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean match = (i < m) && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

                if ((j + 1) < n && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] // skip x*
                            || match && dp[i + 1][j]; // use x*
                } else {
                    if (match) {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String[][] tests = {
                { "aa", "a", "false" },
                { "aa", "a*", "true" },
                { "ab", ".*", "true" },
                { "aab", "c*a*b", "true" },
                { "a", ".", "true" },
        };

        for (int i = 0; i < tests.length; i++) {
            String s = tests[i][0], p = tests[i][1];
            boolean expected = Boolean.parseBoolean(tests[i][2]);
            boolean r1 = isMatch(s, p);
            boolean r2 = isMatch1(s, p);
            System.out.println((r1 == expected ? "PASS" : "FAIL") + " test " + (i + 1) + " isMatch:  result=" + r1
                    + " expected=" + expected);
            System.out.println((r2 == expected ? "PASS" : "FAIL") + " test " + (i + 1) + " isMatch1: result=" + r2
                    + " expected=" + expected);
        }
    }
}
