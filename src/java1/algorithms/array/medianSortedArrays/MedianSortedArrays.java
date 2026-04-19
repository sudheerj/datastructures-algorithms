package medianSortedArrays;

public class MedianSortedArrays {
    public static void main(String[] args) {
        // Test case 1: Even total length
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2, 4 };
        System.out.println("Median (Even total): " + medianSortedArrays(nums1, nums2)); // Expected: 2.5

        // Test case 2: Odd total length
        int[] nums3 = { 1, 2 };
        int[] nums4 = { 3, 4, 5 };
        System.out.println("Median (Odd total): " + medianSortedArrays(nums3, nums4)); // Expected: 3.0

        // Test case 3: One array empty
        int[] nums5 = {};
        int[] nums6 = { 1 };
        System.out.println("Median (One empty): " + medianSortedArrays(nums5, nums6)); // Expected: 1.0

        // Test case 4: Both arrays empty
        int[] nums7 = {};
        int[] nums8 = {};
        try {
            System.out.println("Median (Both empty): " + medianSortedArrays(nums7, nums8)); // Expected: Exception or
                                                                                            // error
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Test case 5: Arrays with negative numbers
        int[] nums9 = { -5, 3, 6 };
        int[] nums10 = { -2, 4, 10 };
        System.out.println("Median (Negatives): " + medianSortedArrays(nums9, nums10)); // Expected: 3.5
    }

    private static double medianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search the smaller array for efficiency
        if (nums1.length > nums2.length) {
            return medianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length, n2 = nums2.length;
        int total = n1 + n2;
        int half = (total + 1) / 2;

        int left = 0, right = n1;

        while (left <= right) {
            int i = (left + right) / 2; // number of elements taken from nums1 into LEFT
            int j = half - i; // number of elements taken from nums2 into LEFT(ensures total left elements =
                              // half)

            // Get boundary values around partition (handle edge cases)
            int firstLeft = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int firstRight = (i < n1) ? nums1[i] : Integer.MAX_VALUE;
            int secondLeft = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int secondRight = (j < n2) ? nums2[j] : Integer.MAX_VALUE;

            // Check if partition is correct: left side max <= right side min across both
            // arrays
            if (firstLeft <= secondRight && secondLeft <= firstRight) {
                // If total length is odd → median is min of right side
                if (total % 2 != 0) {
                    return Math.max(firstLeft, secondLeft);
                } else { // If even → median is avg of boundary values
                    return (Math.max(firstLeft, secondLeft) + Math.min(firstRight, secondRight)) / 2.0;
                }
            }
            // If first left is too big, move partition left
            else if (firstLeft > secondRight) {
                right = i - 1;
            }
            // Otherwise move partition right
            else {
                left = i + 1;
            }
        }
        return 0;
    }
}
