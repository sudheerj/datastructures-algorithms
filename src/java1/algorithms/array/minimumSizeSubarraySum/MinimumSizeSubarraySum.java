// Sliding window: TC: O(n), SC: O(1)
package minimumSizeSubarraySum;

public class MinimumSizeSubarraySum {

    private static int minSizeSubarraySum(int[] nums, int target) {
        int left = 0, right = 0, total = 0, result = Integer.MAX_VALUE;

        while(right < nums.length) {
            total += nums[right];
            while(total >= target) {
                result = Math.min(right-left+1, result);
                total -= nums[left++];
            }
            right++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;

    }

    public static void main(String[] args) {

        int target1 = 7;
        int[] nums1 = {2,4,1,2,4,3};
        int target2 = 5;
        int[] nums2 = {1, 5, 5, 5};
        int target3 = 15;
        int[] nums3 = {2, 2, 2, 2, 2};
        
        System.out.println(minSizeSubarraySum(nums1, target1));
        System.out.println(minSizeSubarraySum(nums2, target2));
        System.out.println(minSizeSubarraySum(nums3, target3));
    }
}
