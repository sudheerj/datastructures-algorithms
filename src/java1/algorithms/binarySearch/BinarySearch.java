package java1.algorithms.binarySearch;

public class BinarySearch {
    //Binary search TC: O(logn) SC: O(1)
    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] { -1, 0, 3, 5, 9, 12 }, 9)); // 4
        System.out.println(binarySearch(new int[] { -1, 0, 3, 5, 9, 12 }, 2)); // -1
        System.out.println(binarySearch(new int[] { 5 }, 5)); // 0
        System.out.println(binarySearch(new int[] { 5 }, 6)); // -1
        System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5 }, 1)); // 0
        System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5 }, 5)); // 4
    }
}
