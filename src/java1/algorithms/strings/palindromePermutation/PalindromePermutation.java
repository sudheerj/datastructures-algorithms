package java1.algorithms.strings.palindromePermutation;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    public static void main(String[] args) {
        PalindromePermutation obj = new PalindromePermutation();

        String[] testCases =  {"aab",  "code", "carerac", "",   "a",  "aa", "ab", "aaabbbb", "aabbccdd"};
        boolean[] expected =  {true,   false,  true,      true, true, true, false, true,      true};

        for (int i = 0; i < testCases.length; i++) {
            boolean result = obj.canPermutePalindrome(testCases[i]);
            System.out.println("\"" + testCases[i] + "\" => " + result + (result == expected[i] ? " ✓" : " ✗ (expected " + expected[i] + ")"));
        }
    }

    private boolean canPermutePalindrome(String str) {
        Set<Character> oddSet = new HashSet<>();
        for(char ch: str.toCharArray()) {
            if(!oddSet.add(ch)) oddSet.remove(ch);
        }

        return oddSet.size() <=1;
    }
}
