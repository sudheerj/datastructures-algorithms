package java1.algorithms.strings.minWindowSubstring;
// Sliding window: TC: O(m) + O(n), SC: O(m) + O(n)

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    private static String minWindowSubstring(String windowStr, String subStr) {

        if (windowStr.isEmpty() || subStr.isEmpty() || windowStr.length() < subStr.length()) return "";

        Map<Character, Integer> subStrCount = new HashMap<>();
        Map<Character, Integer> windowStrCount = new HashMap<>();

        //Step1: Build frequency map of target substring
        for(char ch: subStr.toCharArray()) {
            subStrCount.put(ch, subStrCount.getOrDefault(ch, 0) + 1);
        }

        //Step2: Initialize sliding window
        int minLength = Integer.MAX_VALUE;
        int[] bestWindow = new int[]{-1, -1};

        int having = 0, required = subStrCount.size();
        int left = 0;

        //Step3: Expand window and update counts
        for(int right = 0; right < windowStr.length(); right++) {
            char rightChar = windowStr.charAt(right);
            
            if(subStrCount.containsKey(rightChar)) {
                windowStrCount.put(rightChar, windowStrCount.getOrDefault(rightChar, 0) + 1);
                if(subStrCount.get(rightChar) == windowStrCount.get(rightChar)) {
                    having++;
                } 
            }

            //Step4: Shrink window to find minimized substring
            while(required == having) {
                if(minLength > right-left+1) {
                    minLength = right-left+1;
                    bestWindow[0] = left;
                    bestWindow[1] = right;
                }
                
                char leftChar = windowStr.charAt(left);
                if(subStrCount.containsKey(leftChar)) {
                    windowStrCount.put(leftChar, windowStrCount.get(leftChar)-1);
                    if(windowStrCount.get(leftChar) < subStrCount.get(leftChar)) {
                        having--;
                    }
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : windowStr.substring(bestWindow[0], bestWindow[1]+1);
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
