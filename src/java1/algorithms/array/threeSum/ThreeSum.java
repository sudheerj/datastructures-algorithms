package threeSum;

import java.util.*;

public class ThreeSum {
    // Two pointer approach:- TC: O(n logn) + O(n*2) => O(n * 2), SC: O(1)
    private static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {

                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { 3, 3, -1, -2, 0, -2, 0, -1, 0, -1 }, 0)); // [[-2,-1,3],[-2,0,2],[-1,0,1]]
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }, 0)); // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[] { 0, 0, 0 }, 0)); // [[0,0,0]]
        System.out.println(threeSum(new int[] { 0, 1, 1 }, 0)); // []
        System.out.println(threeSum(new int[] { -2, 0, 0, 2, 2 }, 0)); // [[-2,0,2]]
        System.out.println(threeSum(new int[] { 1, 2, 3 }, 6)); // [[1,2,3]]
    }
}
