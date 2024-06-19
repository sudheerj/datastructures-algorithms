package java1.algorithms.strings.minWindowSubstring;
// Sliding window: TC: O(m) + O(n) SC: O(m) + O(n)

import java.util.HashMap;

public class MinWindowSubstring {

    private static String minWindowSubstring(String windowStr, String subStr) {

        if (subStr == "") return "";

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
            
            if(subStrCount.containsKey(rightChar)) {
                windowStrCount.put(rightChar, windowStrCount.getOrDefault(rightChar, 0) + 1);
                if(subStrCount.get(rightChar).intValue() == windowStrCount.get(rightChar).intValue()) {
                    having++;
                } 
            }

            while(required == having) {
                if(minLength > right-left+1) {
                    minLength = right-left+1;
                    leftIndex = left;
                    rightIndex = right;
                }
                char leftChar = windowStr.charAt(left);

                if(subStrCount.containsKey(leftChar)) {
                    windowStrCount.put(leftChar, windowStrCount.get(leftChar)-1);
                    if(windowStrCount.get(leftChar).intValue() < subStrCount.get(leftChar).intValue()) {
                        having--;
                    }
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
        String s1 ="ADOBECODEBANC", t1 = "ABC";
        System.out.println(minWindowSubstring(s1, t1));

        String s2 ="A", t2 = "A";
        System.out.println(minWindowSubstring(s2, t2));

        String s3 ="a", t3 = "aa";
        System.out.println(minWindowSubstring(s3, t3));
    }
}
