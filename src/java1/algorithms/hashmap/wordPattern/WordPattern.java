package java1.algorithms.hashmap.wordPattern;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    //One-to-one mapping(bijection) using two maps TC: O(n) SC: O(n)
    private static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i=0; i<pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if(charToWord.containsKey(ch) && !charToWord.get(ch).equals(word)) {
                return false;
            }

            if(wordToChar.containsKey(word) && wordToChar.get(word) != ch) {
                return false;
            }

            charToWord.put(ch, word);
            wordToChar.put(word, ch);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));   // true
        System.out.println(wordPattern("abba", "dog cat cat fish"));  // false
        System.out.println(wordPattern("aaaa", "dog dog dog dog"));   // true
        System.out.println(wordPattern("abba", "dog dog dog dog"));   // false
        System.out.println(wordPattern("abc", "dog cat"));            // false
    }

}
