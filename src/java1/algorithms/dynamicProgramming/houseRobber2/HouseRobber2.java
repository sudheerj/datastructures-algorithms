//TC: O(2n) ~O(n), SC:O(1)
package java1.algorithms.dynamicProgramming.houseRobber2;

public class HouseRobber2 {
    private static int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        return Math.max(robHelper(nums, 1, nums.length-1), robHelper(nums, 0, nums.length-2));
    }

    private static int robHelper(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;

        for(int i = start; i<= end; i++) {
            int newRob = Math.max(nums[i]+rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 7, 2, 4}, nums2 = {1, 2, 3}, nums3 = {3};
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
    }
}
