package java1.algorithms.math.palindromeNumber;

public class PalindromeNumber {
    //TC: O(log₁₀ n) — SC: O(1)
    private static boolean isPalindrome(int num) {
        if (num < 0)
            return false;

        int originalNumber = num;
        int reverseNumber = 0;

        while (num > 0) {
            int reminder = num % 10;
            reverseNumber = reverseNumber * 10 + reminder;
            num = num / 10;
        }

        return originalNumber == reverseNumber;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121) + " (expected true)"); // 121 reversed = 121
        System.out.println(isPalindrome(-121) + " (expected false)"); // negative
        System.out.println(isPalindrome(10) + " (expected false)"); // 10 reversed = 01 = 1
        System.out.println(isPalindrome(0) + " (expected true)"); // 0 is palindrome
        System.out.println(isPalindrome(12321) + " (expected true)"); // odd digits
        System.out.println(isPalindrome(1221) + " (expected true)"); // even digits
        System.out.println(isPalindrome(123) + " (expected false)"); // not a palindrome
    }
}
