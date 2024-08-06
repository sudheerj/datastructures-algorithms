//Expanding around center:- TC:O(n) SC:O(n)
package java1.algorithms.strings.longestPalindromicSubstring;

public class LongestPalindromicSubstring {

    private static String longestPalindromicSubstring1(String str) {
        if(str.length() <= 1) return str;

        String maxPalindromicSubstr = str.substring(0, 1);

        for (int i = 0; i < str.length(); i++) {
            String maxOddPalindromicSubstr = expandAroundCenter(str, i, i);
            String maxEvenPalindromicSubstr = expandAroundCenter(str, i, i+1);

            if(maxOddPalindromicSubstr.length() > maxPalindromicSubstr.length()) {
                maxPalindromicSubstr = maxOddPalindromicSubstr;
            }
            if(maxEvenPalindromicSubstr.length() > maxPalindromicSubstr.length()) {
                maxPalindromicSubstr = maxEvenPalindromicSubstr;
            }
        }

        return maxPalindromicSubstr;
    }

    private static String expandAroundCenter(String str, int left, int right) {
        while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left+1, right);
    }

    private static String longestPalindromicSubstring2(String str){
        String longestSubstr = "";
        int longestSubstrLen = 0;
        int left =0, right = 0;

        for(int i=0; i< str.length(); i++) {
            // Odd length
            left = i; right = i;
            while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                if(right-left+1 > longestSubstrLen) {
                    longestSubstr = str.substring(left, right+1);
                    longestSubstrLen = right-left+1;
                }
                left--;
                right++;
            }
            // Even length
            left = i; right = i+1;
            while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                if(right-left+1 > longestSubstrLen) {
                    longestSubstr = str.substring(left, right+1);
                    longestSubstrLen = right-left+1;
                }
                left--;
                right++;
            }
        }
        return longestSubstr;
    }

    public static void main(String[] args) {
        String str1 = "ababd";
        String str2 = "dbbc";
        System.out.println(longestPalindromicSubstring1(str1));
        System.out.println(longestPalindromicSubstring1(str2));
        System.out.println(longestPalindromicSubstring2(str1));
        System.out.println(longestPalindromicSubstring2(str2));
    }
    
}
