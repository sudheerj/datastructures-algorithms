//Expand around center:- TC:O(n*2) SC:O(1)
package java1.algorithms.strings.palindromicSubstrings;

public class PalindromicSubstrings {

    private static int countSubstrings(String str) {

        if(str.length() < 2) return str.length();

        int count = 0;
        for(int i=0; i < str.length(); i++) {
            count += countPalindrome(str, i, i);
            count += countPalindrome(str, i, i+1);
        }
        return count;
    }

    private static int countPalindrome(String str, int left, int right) {

        int count = 0;
        while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "baaab";
        System.out.println(countSubstrings(str));

        String str1 = "abc";
        System.out.println(countSubstrings(str1));

        String str2 = "aaa";
        System.out.println(countSubstrings(str2));
    }
    
}
