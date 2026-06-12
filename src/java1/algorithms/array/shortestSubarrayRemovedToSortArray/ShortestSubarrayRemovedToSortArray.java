package shortestSubarrayRemovedToSortArray;

public class ShortestSubarrayRemovedToSortArray {
    //Two pointer approach TC: O(n) SC: O(1)
    private int findLengthOfShortestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;

        //find longest prefix subarray in non-decreasing order
        while(left+1 < n && nums[left] <= nums[left+1]) {
            left++;
        }

        if(left == n-1) {
            return 0;
        }

        //find longest suffix subarray in non-decreasing order
        while(right > 0 && nums[right-1] <= nums[right]) {
            right--;
        }

        //Find minimum prefix/suffix to remove
        int minSize = Math.min(n-(left+1), right);

        //try merging subarrays
        int i=0, j= right;

        while(i<=left && j<n) {
            if(nums[i] <= nums[j]) {
                minSize = Math.min(minSize, j-(i+1));
                i++;
            } else {
                j++;
            }
        }

        return minSize;
    }
}
