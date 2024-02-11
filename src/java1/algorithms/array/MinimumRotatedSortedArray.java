//TC: O(log n), SC: O(1)

public class MinimumRotatedSortedArray {
    private static int minRotatedSortedArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);

        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] sortedArray = { 3, 4, 5, 6, 7, 1, 2 };
        System.out.println(minRotatedSortedArray(sortedArray));

        int[] sortedArray1 = { 0, 1, 2, 4, 5, 6, 7, 8 };
        System.out.println(minRotatedSortedArray(sortedArray1));
    }
}
