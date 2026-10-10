package java1.algorithms.math.minValuesWithEvenPowersOfTwo;

import java.util.Arrays;

public class MinValuesWithEvenPowersOfTwo {
    // Base-4 representation: TC: O(n * 3 * log M) SC: O(n)(HackerRank)
    public static int[] getMinimumValues(int[] nums) {
        int[] results = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int min = Integer.MAX_VALUE;

            // The small number can be 1, 2, or 3
            for (int small = 1; small <= 3; small++) {
                int remaining = num - small;

                if (remaining < 0) {
                    continue;
                }

                // if num itself can be 1, 2 or 3
                if (remaining == 0) {
                    min = 1;
                    break;
                }

                // remaining should be powers of 4
                if (remaining % 4 != 0) {
                    continue;
                }

                // Count min powers of 4
                int powers = 0;
                while (remaining > 0) {
                    powers += remaining % 4;
                    remaining /= 4;
                }

                // +1 for small numbers
                min = Math.min(min, powers + 1);
            }

            results[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 5, 6, 7 },
                { 9, 10, 11 },
                { 21, 22, 23 },
                { 0 }
        };
        int[][] expected = {
                { 2, 2, 2 },
                { 3, 3, 3 },
                { 3, 3, 3 },
                { -1 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] actual = getMinimumValues(testCases[i]);
            System.out.println("Test " + (i + 1) + ": input=" + Arrays.toString(testCases[i])
                    + ", expected=" + Arrays.toString(expected[i])
                    + ", actual=" + Arrays.toString(actual)
                    + (Arrays.equals(actual, expected[i]) ? " [PASS]" : " [FAIL]"));
        }
    }
}
