package java1.algorithms.hashmap.firstUniqueCharacter;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    // Approach 1: frequency count array TC: O(n) SC: O(26) ~= O(1)
    public static int firstUniqChar1(String str) {
        int[] countArr = new int[26];

        for (char ch : str.toCharArray()) {
            countArr[ch - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (countArr[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    // Approach 2: frequency map TC: O(n) SC: O(n)
    public static int firstUniqChar2(String str) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (charCount.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Object[][] tests = {
                // {input, expected}
                { "leetcode", 0 }, // 'l' at index 0
                { "loveleetcode", 2 }, // 'v' at index 2
                { "zeep", 0 }, // 'z' at index 0
                { "mama", -1 }, // no unique char
                { "aabb", -1 }, // all repeated
                { "z", 0 }, // single char
        };

        System.out.println("--- Approach 1: Frequency Array ---");
        for (Object[] test : tests) {
            String str = (String) test[0];
            int expected = (int) test[1];
            int result = firstUniqChar1(str);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] str=\"" + str + "\" result=" + result + " expected=" + expected);
        }

        System.out.println("--- Approach 2: Frequency Map ---");
        for (Object[] test : tests) {
            String str = (String) test[0];
            int expected = (int) test[1];
            int result = firstUniqChar2(str);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] str=\"" + str + "\" result=" + result + " expected=" + expected);
        }
    }
}
