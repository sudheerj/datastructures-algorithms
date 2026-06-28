package java1.algorithms.array.prefixSum.waysToSplitArray;

public class WaysToSplitArray {
    //Prefix sum + Array partitioning TC: O(n) SC: O(1)
    private static int waysToSplitArray(int[] nums) {
        int totalSum = 0;

        for(int num: nums) {
            totalSum += num;
        }

        int leftSum = 0, count = 0;

        //Right side should have atleast one element
        for(int i=0; i<nums.length-1; i++) {
            leftSum += nums[i];

            if(leftSum >= totalSum - leftSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10, 4, -8, 7})); // 2
        System.out.println(waysToSplitArray(new int[]{2, 3, 1, 0}));   // 2
        System.out.println(waysToSplitArray(new int[]{1, 1}));         // 1
        System.out.println(waysToSplitArray(new int[]{5, -2, 3}));     // 2
        System.out.println(waysToSplitArray(new int[]{-1, -1, -1}));   // 2
    }
}
