package java1.algorithms.hashmap.pivotIndex;

public class PivotIndex {
    private static int pivotIndex(int[] nums){
        int totalSum=0, rightSum=0, leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum = totalSum - leftSum - nums[i];

            if(rightSum == leftSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,6,4,2,5,7};
        int[] nums2 = new int[]{1,2,3,4};
        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
    }
}
