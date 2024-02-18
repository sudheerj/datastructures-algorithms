// Two pointer:- TC:O(n) SC:O(1)
package java1.algorithms.strings;

public class ValidPalindrome {

    private static boolean isValidPalindrome(String str) {
        if(str.length() <=1) return true;

        int p1=0, p2= str.length()-1;
        while(p1 <= p2) {

            char ch1 = str.charAt(p1);
            char ch2 = str.charAt(p2);

            if(Character.isLetterOrDigit(ch1) == false) p1++;
            else if(Character.isLetterOrDigit(ch2) == false) p2--;
            else {
                if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                    return false;
                }
                p1++;
                p2--;
            }
        }
        return true;
    }

    private static boolean isValidPalindrome1(String str) {
        if(str.length() <=1) return true;
        
        int p1=0, p2= str.length()-1;
        while(p1<=p2) {
            char ch1 = str.charAt(p1);
            char ch2 = str.charAt(p2);

            if(!isAlphanumeric(ch1)) p1++;
            else if(!isAlphanumeric(ch2)) p2--;
            else {
                if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                    return false;
                }
                p1++;
                p2--;
            }
        }
        return true;
    }

    private static boolean isAlphanumeric(int codePoint) {
        return (codePoint >=48 && codePoint <= 57) || (codePoint >= 65 && codePoint <=90) || (codePoint >=97 && codePoint <=122);
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
