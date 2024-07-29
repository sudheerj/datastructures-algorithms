package searchRotatedSortedArray;
// TC: O(log n), SC: O(1)
public class SearchRotatedSortedArray {
    private static int searchRotatedSortedArray(int[] nums, int target) {
        int left = 0, right = nums.length -1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[left] <=nums[mid]) { // Left to mid is sorted
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } else { // Mid to right is sorted
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchRotatedSortedArray(nums1, 7));

        int[] nums2 = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchRotatedSortedArray(nums2, 9));
    }
}
