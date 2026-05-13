package java1.algorithms.strings.countSubstringsWithKFrequencyChars;

public class CountSubstringsWithKFrequencyChars {
    // Sliding window two-pointers TC: O(n) SC: O(26) ~= O(1)
    private static int countSubstringsWithKFrequencyChars(String str, int k) {
        int n = str.length();
        int[] charFrequency = new int[26];

        int left = 0, right = 0, result = 0;

        while (right < n) {
            char rightChar = str.charAt(right);
            charFrequency[rightChar - 'a']++;

            while (charFrequency[rightChar - 'a'] >= k) {
                result += n - right;

                char leftChar = str.charAt(left);
                charFrequency[leftChar - 'a']--;
                left++;
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] inputs = { "aabb", "aaaa", "abc", "aab", "abbc", "aabbc", "abc", "aaabbb", "a", "a" };
        int[] ks = { 2, 2, 2, 2, 2, 2, 1, 3, 1, 2 };
        int[] expected = { 5, 6, 0, 2, 4, 8, 6, 7, 1, 0 };

        for (int i = 0; i < inputs.length; i++) {
            int result = countSubstringsWithKFrequencyChars(inputs[i], ks[i]);
            String status = result == expected[i] ? "Yes" : "No (expected " + expected[i] + ")";
            System.out.println("\"" + inputs[i] + "\", k=" + ks[i] + " => " + result + " " + status);
        }
    }
}
