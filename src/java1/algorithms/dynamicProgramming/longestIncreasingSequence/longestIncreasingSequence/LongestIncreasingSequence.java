package java1.algorithms.dynamicProgramming.longestIncreasingSequence.longestIncreasingSequence;

import java.util.Arrays;

public class LongestIncreasingSequence {
    // Bottom-up TC:O(n * 2) SC:O(n)
    private static int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for(int i = nums.length-1; i>=0; i--) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    //using binary search TC: O(n logn) SC: O(n)
    private static int lengthOfLIS2(int[] nums) {
        int[] tail = new int[nums.length];

        int size = 0;
        for(int i=0; i<nums.length; i++) {
            int left = 0, right = size;

            //binary search to find insertion point
            while(left < right) {
                int mid = left +(right-left)/2;
                if(tail[mid] < nums[i]) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            }

            //replace or extend
            tail[left] = nums[i];

            if(size == left) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        // Test cases: [array, expected]
        Object[][] tests = {
            {new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4},
            {new int[]{0, 1, 0, 3, 2, 3}, 4},
            {new int[]{7, 7, 7, 7, 7, 7, 7}, 1},
            {new int[]{9, 7, 1, 4, 2, 6, 10, 12}, 5},
            {new int[]{1, 3, 4, 6, 7, 8}, 6},
            {new int[]{5, 4, 3, 2, 1}, 1},
            {new int[]{1}, 1},
            {new int[]{3, 10, 2, 1, 20}, 3},
            {new int[]{50, 3, 10, 7, 40, 80}, 4},
            {new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}, 6}
        };

        System.out.println("Longest Increasing Subsequence - Test Results:");
        System.out.println("=".repeat(100));

        int passed = 0;
        for(int i = 0; i < tests.length; i++) {
            int[] nums = (int[]) tests[i][0];
            int expected = (int) tests[i][1];

            // Test both approaches
            int result1 = lengthOfLIS1(nums);
            int result2 = lengthOfLIS2(nums);

            boolean pass = (result1 == expected && result2 == expected);

            // Debug: print all results if test fails
            if (!pass) {
                System.out.printf("Test %2d FAIL | Input: %s%n", i + 1, Arrays.toString(nums));
                System.out.printf("  DP: %d, Binary Search: %d | Expected: %d%n",
                        result1, result2, expected);
            } else {
                System.out.printf("Test %2d | Input: %-40s | Output: %d | Expected: %d | PASS%n",
                        i + 1, Arrays.toString(nums), result1, expected);
                passed++;
            }
        }

        System.out.println("=".repeat(100));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
