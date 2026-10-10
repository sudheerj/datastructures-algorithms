package java1.algorithms.greedy.maximizeCappedContributionSum;

import java.util.Arrays;
import java.util.Collections;

public class MaximizeCappedContributionSum {
    // Greedy selection TC: O(n log n) SC: O(n)
    public static long maximizeCappedContributionSum(int[] a, int[] b, int k) {
        long total = 0;
        // Store the improvements from choosing each index
        Integer[] gain = new Integer[a.length];

        for (int i = 0; i < a.length; i++) {
            // contribution without choosing i
            int normal = Math.min(a[i], b[i]);

            // contribution with choosing i
            int doubled = Math.min(a[i], 2 * b[i]);

            total += normal;

            // How much extra do we get?
            gain[i] = doubled - normal;
        }

        // Largest improvements first
        Arrays.sort(gain, Collections.reverseOrder());

        // Contributions from at most k best improvements
        for (int i = 0; i < k && i < gain.length; i++) {
            total += gain[i];
        }

        return total;
    }

    public static void main(String[] args) {
        int[][] aValues = {
                { 5, 3, 8 },
                { 5, 3, 8 },
                { 5, 3, 8 },
                { 1, 4 },
                {}
        };
        int[][] bValues = {
                { 2, 5, 3 },
                { 2, 5, 3 },
                { 2, 5, 3 },
                { 3, 5 },
                {}
        };
        int[] kValues = { 1, 2, 0, 1, 2 };
        long[] expected = { 11, 13, 8, 5, 0 };

        for (int i = 0; i < expected.length; i++) {
            long actual = maximizeCappedContributionSum(aValues[i], bValues[i], kValues[i]);
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + (actual == expected[i] ? " [PASS]" : " [FAIL]"));
        }
    }
}
