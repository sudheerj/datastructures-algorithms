
package java1.algorithms.strings.countHomogenousSubstrings;

public class CountHomogenousSubstrings {
    private static final int MOD = 1_000_000_007;

    // TC: O(n) SC: O(1)
    private static int countHomogenousSubstrings(String str) {
        int count = 0, streak = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                streak += 1; // Extend the current streak;
            } else {
                streak = 1; // Reset the current streak
            }

            // Add substrings at current index and apply modulo to avoid overflow
            count = (count + streak) % MOD;
        }

        return (count + 1) % MOD; // Add substring at first char position
    }

    public static void main(String[] args) {
        // "abbcccaa" -> 13 (1+3+6+3)
        System.out.println(countHomogenousSubstrings("abbcccaa") + " (expected 13)");
        // "xy" -> 2
        System.out.println(countHomogenousSubstrings("xy") + " (expected 2)");
        // "zzzzz" -> 15
        System.out.println(countHomogenousSubstrings("zzzzz") + " (expected 15)");
        // "a" -> 1
        System.out.println(countHomogenousSubstrings("a") + " (expected 1)");
        // "aaa" -> 6
        System.out.println(countHomogenousSubstrings("aaa") + " (expected 6)");
        // "aab" -> 4 (1+2+1 but grouped: aa->3, b->1)
        System.out.println(countHomogenousSubstrings("aab") + " (expected 4)");
    }
}