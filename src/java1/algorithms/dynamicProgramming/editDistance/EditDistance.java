package java1.algorithms.dynamicProgramming.editDistance;

public class EditDistance {
    public static void main(String[] args) {
        String[][] testCases = {
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

        for (int i = 0; i < testCases.length; i++) {
            int result = editDistance(testCases[i][0], testCases[i][1]);
            System.out.println(
                    "\"" + testCases[i][0] + "\", \"" + testCases[i][1] + "\" => " + result +
                            (result == expected[i] ? " ✓" : " ✗ (expected " + expected[i] + ")"));
        }
    }

    private static int editDistance(String w1, String w2) {
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
}
