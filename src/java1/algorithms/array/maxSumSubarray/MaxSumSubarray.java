package maxSumSubarray;

public class MaxSumSubarray {
    private static int maxSumSubArray(int[] nums) {
        if(nums.length == 0) return 0;

        int currentMaxSum = nums[0], globalMaxSum = nums[0];
        for(int i=1; i< nums.length; i++) {
            currentMaxSum = Math.max(nums[i], currentMaxSum+nums[i]);
            globalMaxSum = Math.max(currentMaxSum, globalMaxSum);
        }

        return globalMaxSum;
    }

    public static void main(String[] args) {
        int[] numbers = {-7, -2, 3, 4, -5, 6, 7, -2};
        int maxSumNumbers = maxSumSubArray(numbers);
        System.out.println("Max Subarray Sum:"+ maxSumNumbers); 

        int[] emptyNumbers = {};
        int maxSumEmptyNumbers = maxSumSubArray(emptyNumbers);
        System.out.println("Max Subarray Sum:"+ maxSumEmptyNumbers); 
    }
}
