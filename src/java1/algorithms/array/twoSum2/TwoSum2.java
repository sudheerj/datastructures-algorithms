package twoSum2;
import java.util.*;

public class TwoSum2 {

    private static int[] findTwoSumIndices(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            int total = nums[left] + nums[right];

            if(total == target) {
                return new int[]{left+1, right+1};
            } else if(total > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,7,11,15,9};
        int target1 = 16;
        int[] nums2 = new int[]{-2, 0, 3, 5};
        int target2 = 1;
        System.out.println(Arrays.toString(findTwoSumIndices(nums1, target1)));
        System.out.println(Arrays.toString(findTwoSumIndices(nums2, target2)));
    }
}
