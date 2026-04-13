//Expanding around center:- TC:O(n) SC:O(n)
package java1.algorithms.strings.longestPalindromicSubstring;

public class LongestPalindromicSubstring {
    //TC: O(n**2)  SC:O(1)
    private static String longestPalindromicSubstring1(String str) {
        int start = 0, end = 0;

        for(int i=0; i< str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i); //odd palindromes
            int len2 = expandAroundCenter(str, i, i+1); //even palindromes

            int len = Math.max(len1, len2);

            if(len > end-start) {
                start = i- (len-1)/2;
                end = i + len/2;
            }
        }
        return str.substring(start, end+1);
    }

    private static int expandAroundCenter(String str, int start, int end) {
        while(start >=0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }

        return end-start-1;
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

        private static String longestPalindromicSubstring3(String str) {
        if(str.length() <= 1) return str;

        String maxPalindromicSubstr = str.substring(0, 1);

        for (int i = 0; i < str.length(); i++) {
            String maxOddPalindromicSubstr = expandAroundCenter2(str, i, i);
            String maxEvenPalindromicSubstr = expandAroundCenter2(str, i, i+1);

            if(maxOddPalindromicSubstr.length() > maxPalindromicSubstr.length()) {
                maxPalindromicSubstr = maxOddPalindromicSubstr;
            }
            if(maxEvenPalindromicSubstr.length() > maxPalindromicSubstr.length()) {
                maxPalindromicSubstr = maxEvenPalindromicSubstr;
            }
        }

        return maxPalindromicSubstr;
    }

    private static String expandAroundCenter2(String str, int left, int right) {
        while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left+1, right);
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
