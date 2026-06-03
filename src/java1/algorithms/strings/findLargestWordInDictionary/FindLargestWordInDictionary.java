package java1.algorithms.strings.findLargestWordInDictionary;

import java.util.List;

public class FindLargestWordInDictionary {
    //Two pointers for subsequence TC: O(n * m) SC: O(1) n = dictionary size, m = length of s
    public static String findLargestWordInDictionary(String s, List<String> dictionary) {
        String largestWord = "";

        for (String word : dictionary) {
            if (isSubsequence(s, word)) {
                if (word.length() > largestWord.length()
                        || (word.length() == largestWord.length() && word.compareTo(largestWord) < 0)) {
                    largestWord = word;
                }
            }
        }

        return largestWord;
    }

    private static boolean isSubsequence(String s, String word) {
        int left = 0, right = 0;

        while (left < s.length() && right < word.length()) {
            if (s.charAt(left) == word.charAt(right)) {
                right++;
            }
            left++;
        }

        return right == word.length();
    }

    public static void main(String[] args) {
        Object[][] tests = {
                // {s, dictionary, expected}
                { "abpcplea", List.of("ale", "apple", "monkey", "plea"), "apple" }, // longest subsequence
                { "abpcplea", List.of("a", "b", "c"), "b" }, // tie → lexicographically smallest
                { "abpcplea", List.of("ale", "plea"), "plea" }, // tie by length → lex smallest
                { "aewfafwafjlwajflwajflfa", List.of("apple", "ewaf"), "ewaf" }, // longer word wins
                { "z", List.of("a", "b"), "" }, // no match
                { "", List.of("a"), "" }, // empty s
        };

        for (Object[] test : tests) {
            String s = (String) test[0];
            List<String> dict = (List<String>) test[1];
            String expected = (String) test[2];
            String result = findLargestWordInDictionary(s, dict);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println(
                    "[" + status + "] s=\"" + s + "\" result=\"" + result + "\" expected=\"" + expected + "\"");
        }
    }
}
