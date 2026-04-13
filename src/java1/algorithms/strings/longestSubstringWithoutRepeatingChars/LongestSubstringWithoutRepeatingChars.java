// Sliding window: TC: O(n), SC: O(n)
package java1.algorithms.strings.longestSubstringWithoutRepeatingChars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    private static int longestSubstringLengthWithoutRepeatingChar(String str) {

        HashSet<Character> hashset = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < str.length()) {
            while (hashset.contains(str.charAt(right))) {
                hashset.remove(str.charAt(left));
                left++;
            }
            hashset.add(str.charAt(right));
            right++;
            maxLength = Math.max(maxLength, hashset.size());
        }
        return maxLength;
    }

    private static int longestSubstringLengthWithoutRepeatingCharWithMap(String str) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            char currChar = str.charAt(right);

            if (charIndexMap.containsKey(currChar) && charIndexMap.get(currChar) >= left) {
                left = charIndexMap.get(currChar) + 1;
            }

            charIndexMap.put(currChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String[] testCases = { "abcabcbbaa", "aaaaaaa", "abcdef", "", "a", "abba", "pwwkew", "dvdf" };
        int[] expected = { 3, 1, 6, 0, 1, 2, 3, 3 };

        System.out.println("--- HashSet Approach ---");
        for (int i = 0; i < testCases.length; i++) {
            int result = longestSubstringLengthWithoutRepeatingChar(testCases[i]);
            System.out.println("\"" + testCases[i] + "\" => " + result
                    + (result == expected[i] ? " ✓" : " ✗ (expected " + expected[i] + ")"));
        }

        System.out.println("\n--- HashMap Approach ---");
        for (int i = 0; i < testCases.length; i++) {
            int result = longestSubstringLengthWithoutRepeatingCharWithMap(testCases[i]);
            System.out.println("\"" + testCases[i] + "\" => " + result
                    + (result == expected[i] ? " ✓" : " ✗ (expected " + expected[i] + ")"));
        }
    }

}
