// Two pointer:- TC:O(n) SC:O(1)
package java1.algorithms.strings.validPalindrome;

public class ValidPalindrome {

    private static boolean isValidPalindrome(String str) {
        if(str.length() <=1) return true;

        int left=0, right= str.length()-1;
        while(left < right) {

            char ch1 = str.charAt(left);
            char ch2 = str.charAt(right);

            while(left < right && !Character.isLetterOrDigit(ch1)) left++;
            while(left < right && !Character.isLetterOrDigit(ch2)) right--;

            ch1= str.charAt(left);
            ch2= str.charAt(right);

            if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                    return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isValidPalindrome1(String str) {
        if(str.length() <=1) return true;
        
        int left=0, right= str.length()-1;
        while(left<=right) {
            char ch1 = str.charAt(left);
            char ch2 = str.charAt(right);

            if(!isAlphanumeric(ch1)) left++;
            else if(!isAlphanumeric(ch2)) right--;
            else {
                if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    private static boolean isAlphanumeric(int ch) {
        return (ch >=48 && ch <= 57) || (ch >= 65 && ch <=90) || (ch >=97 && ch <=122);
    }

    public static void main(String[] args) {
        String str1 ="A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(str1));
        System.out.println(isValidPalindrome1(str1));

        String str2 ="Hello World";
        System.out.println(isValidPalindrome(str2));
        System.out.println(isValidPalindrome1(str2));
    }
    
}
