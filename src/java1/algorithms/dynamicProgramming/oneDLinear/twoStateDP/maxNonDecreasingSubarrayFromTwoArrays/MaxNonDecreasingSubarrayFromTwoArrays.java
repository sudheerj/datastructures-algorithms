package java1.algorithms.dynamicProgramming.oneDLinear.twoStateDP.maxNonDecreasingSubarrayFromTwoArrays;

public class MaxNonDecreasingSubarrayFromTwoArrays {
    // 2-State DP: TC: O(n) SC: O(1)
    public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int dp1 = 1;
        int dp2 = 1;

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            int newDp1 = 1;
            int newDp2 = 1;

            // Choose from nums1
            if (nums1[i] >= nums1[i - 1]) {
                newDp1 = Math.max(newDp1, dp1 + 1);
            }
            if (nums1[i] >= nums2[i - 1]) {
                newDp1 = Math.max(newDp1, dp2 + 1);
            }

            // Choose from nums2
            if (nums2[i] >= nums1[i - 1]) {
                newDp2 = Math.max(newDp2, dp1 + 1);
            }

            if (nums2[i] >= nums2[i - 1]) {
                newDp2 = Math.max(newDp2, dp2 + 1);
            }

            dp1 = newDp1;
            dp2 = newDp2;

            maxLength = Math.max(maxLength, Math.max(dp1, dp2));
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[][] nums1Tests = {
                { 2, 3, 1 },
                { 1, 3, 2, 1 },
                { 1, 1 },
                { 7 },
                { 5, 4, 3 },
                { 1, 5, 3, 7 }
        };
        int[][] nums2Tests = {
                { 1, 2, 1 },
                { 2, 2, 3, 4 },
                { 2, 2 },
                { 8 },
                { 1, 2, 3 },
                { 2, 4, 6, 8 }
        };
        int[] expected = { 2, 4, 2, 1, 3, 4 };
        String[] labels = {
                "Example 1",
                "Example 2",
                "Example 3",
                "single element",
                "longer subsequence from nums2",
                "non-decreasing nums2"
        };

        for (int i = 0; i < expected.length; i++) {
            int actual = maxNonDecreasingLength(nums1Tests[i], nums2Tests[i]);
            System.out.println("[" + (actual == expected[i] ? "PASS" : "FAIL") + "] "
                    + labels[i] + ": " + actual + " (expected " + expected[i] + ")");
        }
    }
}
