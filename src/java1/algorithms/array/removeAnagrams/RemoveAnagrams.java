package removeAnagrams;

import java.util.ArrayList;
import java.util.List;

public class RemoveAnagrams {
    //Array traversal + frequency counting TC: O(n * k) SC: O(26); k= maximum or avg length of a word
    private List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();

        for(String word: words) {
            if(result.isEmpty() || !isAnagram(result.get(result.size()-1), word)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean isAnagram(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        int[] freqCount = new int[26];

        for(char ch: word1.toCharArray()) {
            freqCount[ch - 'a']++;
        }

        for(char ch: word2.toCharArray()) {
            freqCount[ch - 'a']--;
        }

        for(int count: freqCount) {
            if(count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        RemoveAnagrams sol = new RemoveAnagrams();

        // Test 1: LeetCode example
        String[] t1 = {"abba", "baba", "bbaa", "cd", "cd"};
        System.out.println("Test 1: " + sol.removeAnagrams(t1));
        // Expected: [abba, cd]

        // Test 2: No anagrams
        String[] t2 = {"abc", "def", "ghi"};
        System.out.println("Test 2: " + sol.removeAnagrams(t2));
        // Expected: [abc, def, ghi]

        // Test 3: All anagrams
        String[] t3 = {"abc", "bca", "cab", "acb"};
        System.out.println("Test 3: " + sol.removeAnagrams(t3));
        // Expected: [abc]

        // Test 4: Consecutive groups
        String[] t4 = {"listen", "silent", "enlist", "cat", "tac", "dog"};
        System.out.println("Test 4: " + sol.removeAnagrams(t4));
        // Expected: [listen, cat, dog]

        // Test 5: Single word
        String[] t5 = {"hello"};
        System.out.println("Test 5: " + sol.removeAnagrams(t5));
        // Expected: [hello]

        // Test 6: Empty array
        String[] t6 = {};
        System.out.println("Test 6: " + sol.removeAnagrams(t6));
        // Expected: []

        // Test 7: Mixed
        String[] t7 = {"a", "a", "b", "b", "ab", "ba", "abc"};
        System.out.println("Test 7: " + sol.removeAnagrams(t7));
        // Expected: [a, b, ab, abc]

        // Test 8: Same letters, different counts
        String[] t8 = {"aab", "aba", "abb", "bab"};
        System.out.println("Test 8: " + sol.removeAnagrams(t8));
        // Expected: [aab, abb]

        // Test 9: Consecutive duplicates
        String[] t9 = {"aa", "aa", "aa", "bb", "bb"};
        System.out.println("Test 9: " + sol.removeAnagrams(t9));
        // Expected: [aa, bb]

        // Test 10: Non-consecutive anagrams
        String[] t10 = {"abc", "xyz", "bca"};
        System.out.println("Test 10: " + sol.removeAnagrams(t10));
        // Expected: [abc, xyz, bca]
        // Note: bca is compared only with xyz, not abc.
    }
}
