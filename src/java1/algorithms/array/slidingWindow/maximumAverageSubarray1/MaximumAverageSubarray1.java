package java1.algorithms.array.slidingWindow.maximumAverageSubarray1;

public class MaximumAverageSubarray1 {
    //Fixed sliding window TC: O(n) SC: O(1)
    private static double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        
        //first window sum
        for(int i=0; i<k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for(int i=k; i<nums.length; i++) {
            windowSum += nums[i];
            windowSum -= nums[i-k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return (double)maxSum/k;
    } 

    public static void main(String[] args) {

        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
        System.out.println(findMaxAverage(new int[]{5}, 1));                     // 5.0
        System.out.println(findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));         // 4.0
        System.out.println(findMaxAverage(new int[]{-1}, 1));                    // -1.0
        System.out.println(findMaxAverage(new int[]{7, 4, 5, 8, 8, 3}, 3));      // 7.0
    }
}
