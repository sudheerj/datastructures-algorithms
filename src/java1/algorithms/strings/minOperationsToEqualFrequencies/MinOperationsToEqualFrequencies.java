package java1.algorithms.strings.minOperationsToEqualFrequencies;

public class MinOperationsToEqualFrequencies {
    // Approach: Frequency Counting + Try All Target Frequencies TC: O(n) SC: O(1)
    private static int minOpsToMakeAllCharsFrequenciesEqual(String str) {
        int[] freqCount = new int[26];

        for (char ch : str.toCharArray()) {
            freqCount[ch - 'a']++;
        }

        int max = 0;
        for (int count : freqCount) {
            max = Math.max(max, count);
        }

        int ans = Integer.MAX_VALUE;

        // Try all possible target frequencies
        for (int target = 1; target <= max; target++) {
            int ops = 0;
            for (int freq : freqCount) {
                if (freq == 0) continue;
                if (freq > target) {
                    ops += freq - target;   // delete excess
                } else if (freq < target) {
                    ops += freq;            // delete all occurrences
                }
                // freq == target: 0 ops needed
            }
            ans = Math.min(ans, ops);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] inputs   = { "abc", "aab", "aabbc", "aaabbc", "aaabbbccc" };
        int[]    expected = {    0,     1,       1,        2,           0  };

        for (int i = 0; i < inputs.length; i++) {
            int result = minOpsToMakeAllCharsFrequenciesEqual(inputs[i]);
            System.out.printf("%s input=\"%s\" result=%d expected=%d%n",
                result == expected[i] ? "[PASS]" : "[FAIL]",
                inputs[i], result, expected[i]);
        }
    }
}
