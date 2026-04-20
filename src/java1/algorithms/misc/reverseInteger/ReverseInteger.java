package java1.algorithms.misc.reverseInteger;

public class ReverseInteger {
    public static void main(String[] args) {
        // Example 1: Positive number
        System.out.println(reverseInteger(123)); // Expected: 321
        // Example 2: Negative number
        System.out.println(reverseInteger(-456)); // Expected: -654
        // Example 3: Number with trailing zeros
        System.out.println(reverseInteger(1200)); // Expected: 21
        // Example 4: Zero
        System.out.println(reverseInteger(0)); // Expected: 0
        // Example 5: Overflow positive
        System.out.println(reverseInteger(1534236469)); // Expected: 0
        // Example 6: Overflow negative
        System.out.println(reverseInteger(-1563847412)); // Expected: 0
    }

    private static int reverseInteger(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && digit > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && digit < -8))
                return 0;

            result = result * 10 + digit;
        }

        return result;
    }
}
