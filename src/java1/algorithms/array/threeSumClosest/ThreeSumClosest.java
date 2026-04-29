package threeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest {
    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i=0; i<length-2; i++) {
            int left = i+1, right = length-1;

            while(left < right) {
                int currSum = nums[i] + nums[left] + nums[right];

                if(Math.abs(currSum-target) < Math.abs(closestSum-target)) {
                    closestSum = currSum;
                }

                if(currSum < target) {
                    left++;
                } else if(currSum > target) {
                    right--;
                } else {
                    return currSum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        // Example test cases
        int[] nums1 = {1, 2, 4, 8, 16, 32, 64, 128};
        int target1 = 82;
        System.out.println(threeSumClosest(nums1, target1)); // Output: 82

        int[] nums2 = {-1, 2, 1, -4};
        int target2 = 1;
        System.out.println(threeSumClosest(nums2, target2)); // Output: 2

        int[] nums3 = {0, 0, 0};
        int target3 = 1;
        System.out.println(threeSumClosest(nums3, target3)); // Output: 0
    }
}
