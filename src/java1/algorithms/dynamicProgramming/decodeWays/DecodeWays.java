package java1.algorithms.dynamicProgramming.decodeWays;

public class DecodeWays {
    // Top-down(Recursion + memoization) TC: O(n) SC: O(n) + recursion stack
    private static int decodeWays1(String str) {
        Integer[] memo = new Integer[str.length()];
        return dfs(str, 0, memo);
    }

    private static int dfs(String str, int i, Integer[] memo) {
        // 1 way to decode after reaching end
        if (i == str.length())
            return 1;

        // cannot decode starting with 0
        if (str.charAt(i) == '0')
            return 0;

        if (memo[i] != null) {
            return memo[i];
        }

        // take 1 digit
        int one = dfs(str, i + 1, memo);

        int two = 0;

        // take 2 digits if valid
        if (i + 1 < str.length()) {
            int value = Integer.parseInt(str.substring(i, i + 2));
            if (value <= 26) {
                two = dfs(str, i + 2, memo);
            }
        }

        return memo[i] = one + two; // store result at index i
    }

    // Bottom-up DP TC: O(n) SC: O(n)
    private static int decodeWays2(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];

        // one way to decode empty string
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                // take 1 digit
                dp[i] = dp[i + 1];

                if (i + 1 < str.length()) {
                    int value = Integer.parseInt(str.substring(i, i + 2));
                    if (value <= 26) {
                        dp[i] += dp[i + 2]; // take 2 digits
                    }
                }
            }
        }

        return dp[0]; // for full string
    }

    // Optimized DP bottom-up two variable solution TC: O(n) SC:O(1)
    private static int decodeWays3(String str) {
        int n = str.length();
        int next1 = 1, next2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int current = 0;
            if (str.charAt(i) != '0') {
                current = next1;

                if (i + 1 < str.length()) {
                    int value = (str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0');
                    if (value <= 26) {
                        current += next2;
                    }
                }
            }
            next2 = next1;
            next1 = current;
        }

        return next1;
    }

    private static String pass(boolean ok) {
        return ok ? "PASS" : "FAIL";
    }

    public static void main(String[] args) {
        int[][] tests = {
                // {expected} paired with strings below
        };
        String[] inputs = { "12", "226", "06", "0", "11106", "1" };
        int[] expected = { 2, 3, 0, 0, 2, 1 };
        String[] labels = {
                "\"12\" → AB or L",
                "\"226\" → BZ, VF, or BBF",
                "\"06\" → leading 0 on two-digit",
                "\"0\" → invalid",
                "\"11106\" → two valid paths",
                "\"1\" → single digit"
        };

        System.out.println("=== Top-down (Memoization) ===");
        for (int i = 0; i < inputs.length; i++) {
            int result = decodeWays1(inputs[i]);
            System.out.println("  [" + pass(result == expected[i]) + "] " + labels[i]
                    + ": " + result + "  (expected " + expected[i] + ")");
        }

        System.out.println("=== Bottom-up DP ===");
        for (int i = 0; i < inputs.length; i++) {
            int result = decodeWays2(inputs[i]);
            System.out.println("  [" + pass(result == expected[i]) + "] " + labels[i]
                    + ": " + result + "  (expected " + expected[i] + ")");
        }

        System.out.println("=== Space-Optimized DP ===");
        for (int i = 0; i < inputs.length; i++) {
            int result = decodeWays3(inputs[i]);
            System.out.println("  [" + pass(result == expected[i]) + "] " + labels[i]
                    + ": " + result + "  (expected " + expected[i] + ")");
        }
    }
}
