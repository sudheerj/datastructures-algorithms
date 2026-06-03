package java1.algorithms.strings.findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    //Frequency counting sliding window TC: O(n + m) ~= O(n) SC: O(26) ~= O(1) n= number of characters in s, m= number of characters in p. Initial build: O(m) and traversal: O(n-m)~=O(n)
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        //no anagrams if p is larger string than s
        if(s.length() < p.length()) {
            return result;
        }

        int[] sWindowCount = new int[26];
        int[] pWindowCount = new int[26];

        //frequency count of p and first window
        for(int i=0; i<p.length(); i++) {
            pWindowCount[p.charAt(i)-'a']++;
            sWindowCount[s.charAt(i)-'a']++;
        }

        //compare first window
        if(Arrays.equals(pWindowCount, sWindowCount)) {
            result.add(0);
        }

        //slide window
        for(int i=p.length(); i<s.length(); i++) {
            //add new char
            sWindowCount[s.charAt(i)-'a']++;
            //remove old char
            sWindowCount[s.charAt(i-p.length())-'a']--;

            //compare new window
            if(Arrays.equals(pWindowCount, sWindowCount)) {
                result.add(i-p.length()+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Object[][] tests = {
            // {s, p, expected}
            {"cbaebabacd", "abc", List.of(0, 6)},  // standard case
            {"abab",       "ab",  List.of(0, 1, 2)}, // overlapping anagrams
            {"af",         "be",  List.of()},         // no anagrams
            {"aa",         "bb",  List.of()},         // no match different chars
            {"a",          "a",   List.of(0)},        // single char match
            {"baa",        "aa",  List.of(1)},        // anagram at end
        };

        for (Object[] test : tests) {
            String s = (String) test[0];
            String p = (String) test[1];
            List<Integer> expected = (List<Integer>) test[2];
            List<Integer> result = findAnagrams(s, p);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] s=\"" + s + "\" p=\"" + p + "\" result=" + result + " expected=" + expected);
        }
    }
}
