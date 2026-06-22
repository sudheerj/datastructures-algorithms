package java1.algorithms.hashmap.commonCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCharacters {
    //Frequency counting + intersection TC: O(n * m) SC: O(1)
    private static List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for(String word: words) {
            int[] freq = new int[26];

            for(char ch: word.toCharArray()) {
                freq[ch-'a']++;
            }

            for(int i=0; i<26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> commonChars = new ArrayList<>();
        for(int i=0; i<26; i++) {
            while(minFreq[i] > 0) {
                commonChars.add(String.valueOf((char) ('a'+i)));
                minFreq[i]--;
            }
        } 

        return commonChars;
    }


    public static void main(String[] args) {

        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));
        System.out.println(commonChars(new String[]{"a", "b", "c"}));
        System.out.println(commonChars(new String[]{"abca", "aabc", "aa"}));
        System.out.println(commonChars(new String[]{"abc", "abc", "abc"}));
        System.out.println(commonChars(new String[]{"apple", "apply", "ape"}));
        System.out.println(commonChars(new String[]{"aaaa", "aaa", "aa"}));
        System.out.println(commonChars(new String[]{"leetcode", "clothes", "cliche"}));
    }
}
