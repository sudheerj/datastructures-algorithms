import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {
    private static int longestSubstringWithKDistinctChars(String str, int k) {
        if (str == null || str.length() == 0 || k == 0)
            return 0;
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(left);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);

                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String[] inputs = { "araaci", "araaci", "cbbebi", "aabbcc", "abc", "abc", "", "aaa", "a", "abaccc" };
        int[] ks = { 2, 1, 3, 2, 3, 1, 2, 0, 1, 2 };
        int[] expected = { 4, 2, 5, 4, 3, 1, 0, 0, 1, 4 };

        for (int i = 0; i < inputs.length; i++) {
            int result = longestSubstringWithKDistinctChars(inputs[i], ks[i]);
            String status = result == expected[i] ? "Yes" : "No (expected " + expected[i] + ")";
            System.out.println("\"" + inputs[i] + "\", k=" + ks[i] + " => " + result + " " + status);
        }
    }
}