package maxSumCircularSubarray;

public class MaxSumCircularSubarray {
    //Using Kadane's algorithm TC: O(n) SC: O(1)
    private static int maxSumCircularSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int globalMaxSum = nums[0], globalMinSum = nums[0];
        int currMaxSum = nums[0], currMinSum = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currMaxSum = Math.max(num, currMaxSum + num);
            currMinSum = Math.min(num, currMinSum + num);

            totalSum += num;
            globalMaxSum = Math.max(globalMaxSum, currMaxSum);
            globalMinSum = Math.min(globalMinSum, currMinSum);
        }

        //If all values are negative, totalSum == globalMinSum. That means globalMaxSum will have incorrect value of 0.
        return globalMaxSum > 0 ? Math.max(globalMaxSum, totalSum - globalMinSum) : globalMaxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = { 9, -9, 6, 11, -6, -10, 15, 1 };
        System.out.println(maxSumCircularSubarray(nums1));

        int[] nums2 = { 6, -2, 6 };
        System.out.println(maxSumCircularSubarray(nums2));

        int[] nums3 = { -6, -2, -6 };
        System.out.println(maxSumCircularSubarray(nums3));

        int[] nums4 = {};
        System.out.println(maxSumCircularSubarray(nums4));
    }
}
