package java1.algorithms.array.setMismatch;

import java.util.Arrays;

public class SetMismatch {
    private static int[] findDuplicateAndMissing(int[] nums){
        int length = nums.length;
        int duplicate = -1;
        int missing = -1;

        for (int num : nums) {
            num = Math.abs(num);
            if(nums[num-1]<0) {
                duplicate = num;
            } else {
                nums[num-1] = -nums[num-1];
            }
        }

        for (int i=0; i< length; i++) {
            if(nums[i]>0) {
                missing = i+1;
            }
        }

        return new int[]{duplicate, missing};
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,3,4};
        int[] nums2 = new int[]{1,1};

        System.out.println(Arrays.toString(findDuplicateAndMissing(nums1)));
        System.out.println(Arrays.toString(findDuplicateAndMissing(nums2)));
    }
}
