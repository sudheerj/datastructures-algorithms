package java1.algorithms.strings.stringToInteger;

public class StringToInteger {
    // String traversal TC: O(n) SC: O(1)
    private static int myAtoI(String str) {
        int n = str.length();
        int i = 0;
        long result = 0;
        int sign = 1;

        // Skip leading whitespace
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        // Check sign (only once)
        if (i < n && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // Convert digits
        while (i < n && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i) - '0');
            i++;

            // Handle overflow
            if (sign * result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        String[] inputs = { "42", "   -042", "1337c0d3", "0-1", "-91283472332" };
        int[] expected = { 42, -42, 1337, 0, Integer.MIN_VALUE };

        for (int i = 0; i < inputs.length; i++) {
            int result = myAtoI(inputs[i]);
            String status = result == expected[i] ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected[i]);
        }
    }
}
