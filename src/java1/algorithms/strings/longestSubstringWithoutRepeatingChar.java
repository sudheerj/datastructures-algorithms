// Sliding window: TC: O(n), SC: O(n)
package java1.algorithms.strings;

import java.util.HashSet;

public class longestSubstringWithoutRepeatingChar {
    private static int longestSubstringLengthWithoutRepeatingChar(String str) {
        HashSet<Character> hashset = new HashSet<>();
        int left = 0, max = 0;
    
        for(int right = 0; right < str.length(); right++) {
            while(hashset.contains(str.charAt(right))){
                hashset.remove(str.charAt(left));
                left++;
            }
            hashset.add(str.charAt(right));
            max = Math.max(max, hashset.size());
        }
        return max;
    }

    public static void main(String[] args) {
        String string1 = "abcabcbbaa";
        System.out.println(longestSubstringLengthWithoutRepeatingChar(string1));
        String string2 = "aaaaaaa";
        System.out.println(longestSubstringLengthWithoutRepeatingChar(string2));
    }
    
}
