// TC:O(n * 2) SC:O(n)
package java1.algorithms.dynamicProgramming.longestIncreasingSequence;

import java.util.Arrays;

public class LongestIncreasingSequence {
    private static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 0;
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

    public static void main(String[] args) {
        int[] nums1 = {9,7,1,4,2,6,10,12};
        int[] nums2 = {1,3,4,6,7,8};
        int[] nums3 = {5,4,3,2,1};
        System.out.println(lengthOfLIS(nums1));
        System.out.println(lengthOfLIS(nums2));
        System.out.println(lengthOfLIS(nums3));
    }
}
