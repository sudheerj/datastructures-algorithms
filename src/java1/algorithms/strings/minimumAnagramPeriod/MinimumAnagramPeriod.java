package java1.algorithms.strings.minimumAnagramPeriod;

public class MinimumAnagramPeriod {
    /**
     * Returns the smallest block length that divides the string into blocks
     * with identical character frequencies.
     */
    public static int getAnagramPeriod(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return 0;
        }

        int n = inputStr.length();

        // Try candidate block lengths in increasing order; the first valid one is minimal.
        for (int period = 1; period <= n; period++) {
            if (n % period != 0) {
                continue;
            }

            int[] expectedFrequency = getFrequency(inputStr, 0, period);
            boolean valid = true;

            for (int start = period; start < n; start += period) {
                if (!hasSameFrequency(inputStr, start, start + period, expectedFrequency)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                return period;
            }
        }

        return n;
    }

    private static int[] getFrequency(String inputStr, int start, int end) {
        int[] frequency = new int[26];
        for (int i = start; i < end; i++) {
            frequency[inputStr.charAt(i) - 'a']++;
        }
        return frequency;
    }

    private static boolean hasSameFrequency(String inputStr, int start, int end, int[] expectedFrequency) {
        int[] frequency = getFrequency(inputStr, start, end);
        for (int letter = 0; letter < 26; letter++) {
            if (frequency[letter] != expectedFrequency[letter]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "abcbcacba",
                "ababbaab",
                "aaaaaa",
                "abc",
                "abab"
        };
        int[] expected = { 3, 2, 1, 3, 2 };
        String[] labels = {
                "Example 1: three anagram blocks",
                "Example 2: repeated two-character blocks",
                "all characters identical",
                "no shorter valid block",
                "two identical anagram blocks"
        };

        for (int i = 0; i < inputs.length; i++) {
            int actual = getAnagramPeriod(inputs[i]);
            System.out.println("[" + (actual == expected[i] ? "PASS" : "FAIL") + "] "
                    + labels[i] + ": " + actual + " (expected " + expected[i] + ")");
        }
    }
}
