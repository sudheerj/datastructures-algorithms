// TC:O(n * 2) SC:O(n)
package java1.algorithms.dynamicProgramming;

public class LongestIncreasingSequence {
    private static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 0;
        for(int i = 1; i<nums.length; i++) {
            int len = 0;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    len = Math.max(len, dp[j]);
                }
                dp[i] = 1 + len;
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
