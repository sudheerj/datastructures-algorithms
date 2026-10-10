package java1.algorithms.strings.prefixBalance.maxEqualizedSubstrings;

public class MaxEqualizedSubstrings {
    // Prefix balance + mathematical observation: TC: O(n) SC:O(1)
    public static int maxEqualizedSubstrings(String s) {
        int balance = 0, count = 0;

        // 1. Count existing equalized substrings
        for (char ch : s.toCharArray()) {
            balance += ch == 'R' ? +1 : -1;

            if (balance == 0) {
                count++;
            }
        }

        balance = 0;
        // 2. check whether one swap add extra substring
        for (int i = 0; i < s.length() - 1; i++) {
            balance += s.charAt(i) == 'R' ? +1 : -1;

            // RL => LR
            if (s.charAt(i) == 'R' && s.charAt(i + 1) == 'L' && balance == 2) {
                return count + 1;
            }
            // LR => RL
            if (s.charAt(i) == 'L' && s.charAt(i + 1) == 'R' && balance == -2) {
                return count + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] testStrings = { "RLRL", "RRLL", "LLRR", "RLLR", "RRLLRR", "RR" };
        int[] expected = { 2, 2, 2, 2, 2, 0 };

        for (int i = 0; i < testStrings.length; i++) {
            int actual = maxEqualizedSubstrings(testStrings[i]);
            System.out.println("Test " + (i + 1) + " (\"" + testStrings[i] + "\"): expected="
                    + expected[i] + ", actual=" + actual
                    + (actual == expected[i] ? " [PASS]" : " [FAIL]"));
        }
    }
}
