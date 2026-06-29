package java1.algorithms.strings.slidingWindow.countSubstringWithoutRepeatingChar;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringWithoutRepeatingChar {
    //Sliding window + contribution counting TC: O(n) SC: O(n)
    private static int countSubstrings(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int count =0, left =0;

        for(int right =0; right<s.length(); right++) {
            char ch = s.charAt(right);

            if(lastSeen.containsKey(ch) && lastSeen.get(ch) >= left) {
                left = lastSeen.get(ch) + 1;
            }

            lastSeen.put(ch,right);

            count += right-left+1;
        }
        return count;
    }

    //Sliding window +  counting index TC: O(n) SC: O(1)
    private static int countSubstringsOptimized(String s) {
        int[] lastIndex = new int[26];

        for(int i=0; i<26; i++) {
            lastIndex[i] = -1;
        }

        int left = 0, count = 0;

        for(int right =0; right<s.length(); right++) {
            int ch = s.charAt(right) - 'a';

            if(lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }

            lastIndex[ch] = right;

            count += right-left+1;
        }

        return count;
    }

    public static void main(String[] args) {

        String[] tests = {
            "abc",
            "aaa",
            "abca",
            "abcd",
            "abba",
            "",
            "a",
            "aabcbc",
            "pwwkew"
        };

        System.out.println("Count Substrings Without Repeating Characters\n");

        for (String s : tests) {
            System.out.println("Input: \"" + s + "\"");

            long r1 = countSubstrings(s);
            System.out.println("HashMap result: " + r1);

            if (s.matches("[a-z]*")) {
                long r2 = countSubstringsOptimized(s);
                System.out.println("Array result:   " + r2);
            } else {
                System.out.println("Array result:   Skipped (non a-z)");
            }

            System.out.println("-----------------------------------");
        }
    }
}
