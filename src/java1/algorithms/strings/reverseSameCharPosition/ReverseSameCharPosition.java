package java1.algorithms.strings.reverseSameCharPosition;

public class ReverseSameCharPosition {
    private static int reverseSameCharPosition(String str) {
        int samePositionCount = 0;
        int len = str.length();

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == str.charAt(len - 1 - i)) {
                samePositionCount++;
            }
        }
        return samePositionCount;
    }

    public static void main(String[] args) {
        // Test 1: Palindrome - all chars same position after reverse
        System.out.println("Test 1: " + reverseSameCharPosition("abcba")); // 5

        // Test 2: No chars same position after reverse
        System.out.println("Test 2: " + reverseSameCharPosition("abcd")); // 0

        // Test 3: Even-length palindrome
        System.out.println("Test 3: " + reverseSameCharPosition("abba")); // 4

        // Test 4: Only middle char stays
        System.out.println("Test 4: " + reverseSameCharPosition("hello")); // 1 (l at index 2)

        // Test 5: All same characters
        System.out.println("Test 5: " + reverseSameCharPosition("aaaa")); // 4

        // Test 6: Single character
        System.out.println("Test 6: " + reverseSameCharPosition("a")); // 1
    }
}
