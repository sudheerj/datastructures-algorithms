// Sliding window: TC: O(n), SC: O(n)
package java1.algorithms.strings.longestSubstringWithoutRepeatingChars;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {

    private static int longestSubstringLengthWithoutRepeatingChar(String str) {
        
        HashSet<Character> hashset = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;
    
        while(right < str.length()) {
            while(hashset.contains(str.charAt(right))){
                hashset.remove(str.charAt(left));
                left++;
            }
            hashset.add(str.charAt(right));
            right++;
            maxLength = Math.max(maxLength, hashset.size());
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String string1 = "abcabcbbaa";
        System.out.println(longestSubstringLengthWithoutRepeatingChar(string1));
        
        String string2 = "aaaaaaa";
        System.out.println(longestSubstringLengthWithoutRepeatingChar(string2));
    }
    
}
