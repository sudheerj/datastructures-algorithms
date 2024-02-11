public class SearchRotatedSortedArray {
    private static int searchRotatedSortedArray(int[] nums, int target) {
        int left = 0, right = nums.length -1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) 
        }
    }
}
