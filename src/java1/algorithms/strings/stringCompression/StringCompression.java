package java1.algorithms.strings.stringCompression;

import java.util.Arrays;

public class StringCompression {
    // Two pointers TC: O(n) SC: O(1)
    private static int compress(char[] chars) {
        int read = 0; // position to scan input chars
        int write = 0; // position to write output

        while (read < chars.length) {
            char current = chars[read];
            int count = 0;

            // count how many times current repeats
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            // write current character
            chars[write++] = current;

            // write count if its more than 1
            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[write++] = ch;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {
        Object[][] tests = {
                { new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }, 6, new char[] { 'a', '2', 'b', '2', 'c', '3' } },
                { new char[] { 'a' }, 1, new char[] { 'a' } },
                { new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' }, 4,
                        new char[] { 'a', 'b', '1', '2' } },
                { new char[] { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' }, 3, new char[] { 'a', '1', '0' } },
                { new char[] { 'a', 'b', 'c' }, 3, new char[] { 'a', 'b', 'c' } },
        };

        for (Object[] test : tests) {
            char[] chars = (char[]) test[0];
            int expectedLen = (int) test[1];
            char[] expectedChars = (char[]) test[2];

            int result = compress(chars);
            char[] resultChars = Arrays.copyOf(chars, result);
            boolean pass = result == expectedLen && Arrays.equals(resultChars, expectedChars);
            System.out.println("[" + (pass ? "PASS" : "FAIL") + "] result=" + result
                    + " chars=" + Arrays.toString(resultChars)
                    + " expected=" + expectedLen
                    + " expectedChars=" + Arrays.toString(expectedChars));
        }
    }
}
