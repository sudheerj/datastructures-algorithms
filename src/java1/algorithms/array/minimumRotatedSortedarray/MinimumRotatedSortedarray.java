package minimumRotatedSortedarray;
//TC: O(log n), SC: O(1)

public class MinimumRotatedSortedarray {
    private static int minRotatedSortedArray(int[] nums) {
        int result = nums[0];

        if (nums.length == 1)
            return result;
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (nums[left] <= nums[right]) {
                result = nums[left];
                break;
            }

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = { 3, 4, 5, 6, 7, 1, 2 };
        System.out.println(minRotatedSortedArray(sortedArray));

        int[] sortedArray1 = { 0, 1, 2, 4, 5, 6, 7, 8 };
        System.out.println(minRotatedSortedArray(sortedArray1));
    }
}
