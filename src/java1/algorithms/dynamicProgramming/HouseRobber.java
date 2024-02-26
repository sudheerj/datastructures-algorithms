package java1.algorithms.dynamicProgramming;

public class HouseRobber {
    // TC:O(n) SC:O(1)
    private static int robber1(int[] nums) {
        int rob1 = nums[0], rob2 = Math.max(rob1, nums[1]);
        for(int i=2; i< nums.length; i++) {
            int temp = Math.max(nums[i]+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    } 

    // TC:O(n) SC:O(n)
    private static int robber2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }   

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(robber1(nums));
        System.out.println(robber2(nums));
    }
}
