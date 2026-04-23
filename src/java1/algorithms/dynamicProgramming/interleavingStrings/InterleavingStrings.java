package java1.algorithms.dynamicProgramming.interleavingStrings;

public class InterleavingStrings {
    public static void main(String[] args) {
        // Example 1: Simple interleaving
        System.out.println(
                "Input: s1=\"aab\", s2=\"axy\", s3=\"aaxaby\" -> Output: " + isInterleave("aab", "axy", "aaxaby")); // true

        // Example 2: Not interleaving
        System.out.println(
                "Input: s1=\"aab\", s2=\"axy\", s3=\"abaaxy\" -> Output: " + isInterleave("aab", "axy", "abaaxy")); // false

        // Example 3: Both strings empty, s3 empty
        System.out.println("Input: s1=\"\", s2=\"\", s3=\"\" -> Output: " + isInterleave("", "", "")); // true

        // Example 4: One string empty, s3 matches other
        System.out.println("Input: s1=\"abc\", s2=\"\", s3=\"abc\" -> Output: " + isInterleave("abc", "", "abc")); // true
        System.out.println("Input: s1=\"\", s2=\"xyz\", s3=\"xyz\" -> Output: " + isInterleave("", "xyz", "xyz")); // true

        // Example 5: Length mismatch
        System.out
                .println("Input: s1=\"abc\", s2=\"def\", s3=\"abcd\" -> Output: " + isInterleave("abc", "def", "abcd")); // false

        // Example 6: Interleaving with repeated characters
        System.out.println("Input: s1=\"aa\", s2=\"ab\", s3=\"aaba\" -> Output: " + isInterleave("aa", "ab", "aaba")); // true
    }

    // DP bottom-up approach TC: O(m*n) SC: O(m*n)
    private static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length())
            return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n)
                    continue;

                int k = i + j;

                boolean fromS1 = i < m && s1.charAt(i) == s3.charAt(k) && dp[i + 1][j];
                boolean fromS2 = j < n && s2.charAt(j) == s3.charAt(k) && dp[i][j + 1];

                dp[i][j] = fromS1 || fromS2;
            }
        }

        return dp[0][0];
    }
}
