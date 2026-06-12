package java1.algorithms.dynamicProgramming.editDistance;

public class EditDistance {
    // top-down DP memoization TC: O(m*n) SC: O(m*n)
    private static int editDistance1(String w1, String w2) {
        int m = w1.length(), n = w2.length();

        int[][] memo = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                memo[r][c] = -1;
            }
        }

        return dfs(0, 0, w1, w2, memo, m, n);
    }

    private static int dfs(int r, int c, String w1, String w2, int[][] memo, int m, int n) {
        if (r == m)
            return n - c;
        if (c == n)
            return m - r;

        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        if (w1.charAt(r) == w2.charAt(c)) {
            memo[r][c] = dfs(r + 1, c + 1, w1, w2, memo, m, n);
        } else {
            memo[r][c] = Math.min(Math.min(dfs(r, c + 1, w1, w2, memo, m, n), dfs(r + 1, c, w1, w2, memo, m, n)),
                    dfs(r + 1, c + 1, w1, w2, memo, m, n));
        }

        return memo[r][c];
    }

    // Bottom-up DP TC: O(m * n) SC: O(m * n)
    private static int editDistance2(String w1, String w2) {
        int m = w1.length(), n = w2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialize last row
        for (int i = 0; i < n; i++) {
            dp[m][i] = n - i;
        }

        // Initialize last column
        for (int j = 0; j < m; j++) {
            dp[j][n] = m - j;
        }

        // Fill DP from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (w1.charAt(i) == w2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i + 1][j + 1]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        String[][] tests = {
                { "horse", "ros" },
                { "intention", "execution" },
                { "", "abc" },
                { "abc", "" },
                { "abc", "abc" },
                { "kitten", "sitting" },
                { "flaw", "lawn" },
                { "a", "b" },
                { "", "" }
        };
        int[] expected = { 3, 5, 3, 3, 0, 3, 2, 1, 0 };
        String[] labels = {
                "horse→ros", "intention→execution", "empty→abc", "abc→empty",
                "abc→abc", "kitten→sitting", "flaw→lawn", "a→b", "empty→empty"
        };

        System.out.println("=== Approach 1: Top-down Memoization ===");
        for (int i = 0; i < tests.length; i++) {
            int result = editDistance1(tests[i][0], tests[i][1]);
            System.out.println("[" + (result == expected[i] ? "PASS" : "FAIL") + "] " + labels[i] + ": " + result
                    + "  (expected " + expected[i] + ")");
        }

        System.out.println("=== Approach 2: Bottom-up DP ===");
        for (int i = 0; i < tests.length; i++) {
            int result = editDistance2(tests[i][0], tests[i][1]);
            System.out.println("[" + (result == expected[i] ? "PASS" : "FAIL") + "] " + labels[i] + ": " + result
                    + "  (expected " + expected[i] + ")");
        }
    }
}
