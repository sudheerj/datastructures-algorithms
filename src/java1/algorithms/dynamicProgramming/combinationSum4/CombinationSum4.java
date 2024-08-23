// TC: O(nums * target) SC: O(target)
package java1.algorithms.dynamicProgramming.combinationSum4;

public class CombinationSum4 {
    private static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i =1; i<=target; i++) {
            for(int num: nums) {
                if(i>=num) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
       int[] nums1 = {1, 2, 4}, nums2 = {7};
       int target1 = 5, target2 = 6;
       System.out.println(combinationSum4(nums1, target1));
       System.out.println(combinationSum4(nums2, target2));
    }
}
