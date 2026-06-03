package java1.algorithms.dynamicProgramming.countNumberOfTexts;

public class CountNumberOfTexts {
    private static final int MOD = 1000000007;
    
    // Bottom-up DP approach TC: O(n) SC: O(n)
    private static int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            char c = pressedKeys.charAt(i - 1);
            int maxPress = (c == '7' || c == '9') ? 4 : 3;
            
            dp[i] = dp[i - 1];
            
            for (int j = 2; j <= maxPress && i - j >= 0; j++) {
                boolean allSame = true;
                for (int k = i - j; k < i - 1; k++) {
                    if (pressedKeys.charAt(k) != c) {
                        allSame = false;
                        break;
                    }
                }
                if (allSame) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                } else {
                    break;
                }
            }
        }
        
        return (int) dp[n];
    }

    public static void main(String[] args) {
        String[][] tests = {
            {"22233", "8"},          // "aaadd", "awdd", "abdd", "aaed", "awed", "abed", "acdd", "aced"
            {"222222222222222222222222222222222222", "82876089"},  // Large sequence of 2s
            {"2", "1"},              // Single key: "a"
            {"23", "2"},             // "ad", "bd"
            {"77799", "12"},         // Multiple 7s and 9s
            {"777", "4"},            // "ppp", "pp", "p", "s"
            {"9999999999", "40"},    // 10 nines
            {"234", "4"},            // Various keys
            {"33", "2"},             // "dd", "e"
            {"7777777777", "196"}    // 10 sevens
        };

        System.out.println("Count Number of Texts - Test Results:");
        System.out.println("=".repeat(70));
        
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            String input = tests[i][0];
            int expected = Integer.parseInt(tests[i][1]);
            int result = countTexts(input);
            boolean pass = result == expected;
            
            if (pass) passed++;
            
            String displayInput = input.length() > 15 ? input.substring(0, 12) + "..." : input;
            System.out.printf("Test %2d | Input: %-15s | Output: %-10d | Expected: %-10d | %s%n",
                i + 1, displayInput, result, expected, pass ? "PASS" : "FAIL");
        }
        
        System.out.println("=".repeat(70));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
