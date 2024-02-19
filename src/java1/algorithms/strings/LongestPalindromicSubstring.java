//Expanding around center:- TC:O(n) SC:O(n)
package java1.algorithms.strings;

public class LongestPalindromicSubstring {
    private static String longestPalindromicSubstring(String str){
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
        String str = "dbabad";
        System.out.println(longestPalindromicSubstring(str));
    }
    
}
