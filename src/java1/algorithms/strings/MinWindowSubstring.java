package java1.algorithms.strings;
// Sliding window: TC: O(m) + O(n) SC: O(m) + O(n)

import java.util.HashMap;

public class MinWindowSubstring {
    private static String minWindowSubstring(String windowStr, String subStr) {
        HashMap<Character, Integer> subStrCount = new HashMap<>();
        HashMap<Character, Integer> windowStrCount = new HashMap<>();

        int minLength = Integer.MAX_VALUE;
        int leftIndex = -1, rightIndex = -1;

        for(int i=0; i< subStr.length(); i++) {
            char ch = subStr.charAt(i);
            subStrCount.put(ch, subStrCount.getOrDefault(ch, 0) + 1);
        }

        int having = 0, required = subStrCount.size();
        int left = 0;
        for(int right = 0; right < windowStr.length(); right++) {
            char rightChar = windowStr.charAt(right);
            windowStrCount.put(rightChar, windowStrCount.getOrDefault(rightChar, 0) + 1);
            if(subStrCount.containsKey(rightChar) && subStrCount.get(rightChar).intValue() == windowStrCount.get(rightChar).intValue()) {
                having++;
            }

            while(required == having) {
                if(minLength > right-left+1) {
                    minLength = right-left+1;
                    leftIndex = left;
                    rightIndex = right;
                }
                char leftChar = windowStr.charAt(left);
                windowStrCount.put(leftChar, windowStrCount.get(leftChar)-1);
                if(subStrCount.containsKey(leftChar) && subStrCount.get(leftChar).intValue() > windowStrCount.get(leftChar).intValue()) {
                    having--;
                }
                left++;
            }
        }
        if(leftIndex == -1 || rightIndex == -1) {
            return "";
        } else {
            return windowStr.substring(leftIndex, rightIndex+1);
        }

    }

    public static void main(String[] args) {
        String s ="ADOBECODEBANC", t= "ABC";
        System.out.println(minWindowSubstring(s, t));
    }
}
