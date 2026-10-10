package java1.algorithms.dynamicProgramming.sequence.longestStringChain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    // 1 DP + HashMap: TC: O(n log n + N * M^2) SC: O(n)
    public static int longestStringChain(String[] words) {
        if (words.length == 0) {
            return 0;
        }

        // Process shorted words first
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // Longest string chain ending at word
        Map<String, Integer> dp = new HashMap<>();

        int longestChainLength = 1;

        for (String word : words) {
            int currentChainLength = 1;

            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(predecessor)) {
                    currentChainLength = Math.max(currentChainLength, 1 + dp.get(predecessor));
                }
            }
            dp.put(word, currentChainLength);

            longestChainLength = Math.max(longestChainLength, currentChainLength);
        }

        return longestChainLength;
    }

    public static void main(String[] args) {
        String[][] testCases = {
                { "a", "b", "ba", "bca", "bda", "bdca" },
                { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" },
                { "abcd", "dbqca" },
                { "a" },
                {}
        };
        int[] expected = { 4, 5, 1, 1, 0 };

        for (int i = 0; i < testCases.length; i++) {
            int actual = longestStringChain(testCases[i]);
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + (actual == expected[i] ? " [PASS]" : " [FAIL]"));
        }
    }
}
