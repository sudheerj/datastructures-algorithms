package java1.algorithms.strings.validPalindrome2;

public class ValidPalindrome2 {
    private static boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "aba",      // true
            "abca",     // true (remove 'b' or 'c')
            "abc",      // false
            "deeee",    // true (remove 'd')
            "racecar",  // true
            "raceacar", // true (remove extra 'a')
            "abcdef"    // false
        };

        for (String s : testCases) {
            System.out.printf("Input: %-10s Result: %b%n",
                    "\"" + s + "\"",
                    validPalindrome(s));
        }
    }
}
