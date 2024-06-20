//Two pointers:- TC:O(n) SC: O(1)
package sortColors;

import java.util.Arrays;

public class SortColors {

    private static int[] sortColors(int[] nums) {
        int left = 0, i = 0, right = nums.length-1;

        while(i <= right) {
            if(nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if(nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,0,2,1,1,0};
        int[] nums2 = {2,0,1};
        System.out.println(Arrays.toString(sortColors(nums1)));
        System.out.println(Arrays.toString(sortColors(nums2)));

    }
    
}
