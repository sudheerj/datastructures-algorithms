package java1.algorithms.dynamicProgramming.houseRobber;

public class HouseRobber {
    // TC:O(n) SC:O(1)
    private static int robber1(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for(int num: nums) {
            int newRob = Math.max(num+rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    } 

    // TC:O(n) SC:O(n)
    private static int robber2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }   

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 7, 2, 4};
        int[] nums2 = {8, 1, 2, 9};
        System.out.println(robber1(nums1));
        System.out.println(robber2(nums1));

        System.out.println(robber1(nums2));
        System.out.println(robber2(nums2));
    }
}
