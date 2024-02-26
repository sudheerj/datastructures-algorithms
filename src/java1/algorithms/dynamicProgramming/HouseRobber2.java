//TC: O(2n) ~O(n), SC:O(1)
package java1.algorithms.dynamicProgramming;

public class HouseRobber2 {
    private static int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robHelper(nums, 1, nums.length-1), robHelper(nums, 0, nums.length-2));
    }

    private static int robHelper(int[] nums, int start, int end) {
        int rob1 = nums[start], rob2 = nums[start+1];

        for(int i = 2; i< nums[end]; i++) {
            int temp = Math.max(nums[i]+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
