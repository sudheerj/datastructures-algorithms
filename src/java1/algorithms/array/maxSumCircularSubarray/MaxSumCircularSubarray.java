package maxSumCircularSubarray;

public class MaxSumCircularSubarray {
    private static int maxSumCircularSubarray(int[] nums) {
        if(nums.length == 0) return 0;

        int globalMaxSum = nums[0], globalMinSum = nums[0];
        int currMaxSum = 0, currMinSum = 0;
        int totalSum = 0;

        for (int num : nums) {
            currMaxSum = Math.max(currMaxSum+num, num);
            currMinSum = Math.min(currMinSum+num, num);

            totalSum += num;
            globalMaxSum = Math.max(globalMaxSum, currMaxSum);
            globalMinSum = Math.min(globalMinSum, currMinSum);
        }

        return globalMaxSum > 0 ? Math.max(globalMaxSum, totalSum-globalMinSum) : globalMaxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {9, -9, 6, 11, -6, -10, 15, 1};
        System.out.println(maxSumCircularSubarray(nums1));

        int[] nums2 = {6,-2,6};
        System.out.println(maxSumCircularSubarray(nums2));

        int[] nums3 = {-6,-2,-6};
        System.out.println(maxSumCircularSubarray(nums3));

        int[] nums4 = {};
        System.out.println(maxSumCircularSubarray(nums4));
    }
}
