package removeDuplicatesSortedArray;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        // Test 1: General case with duplicates
        int[] nums1 = {1, 1, 2};
        int count1 = removeDuplicates(nums1);
        System.out.println("Test 1: " + Arrays.toString(Arrays.copyOfRange(nums1, 0, count1))); // [1, 2]

        // Test 2: Multiple duplicates
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count2 = removeDuplicates(nums2);
        System.out.println("Test 2: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, count2))); // [0, 1, 2, 3, 4]

        // Test 3: No duplicates
        int[] nums3 = {1, 2, 3, 4, 5};
        int count3 = removeDuplicates(nums3);
        System.out.println("Test 3: " + Arrays.toString(Arrays.copyOfRange(nums3, 0, count3))); // [1, 2, 3, 4, 5]

        // Test 4: Single element
        int[] nums4 = {1};
        int count4 = removeDuplicates(nums4);
        System.out.println("Test 4: " + Arrays.toString(Arrays.copyOfRange(nums4, 0, count4))); // [1]

        // Test 5: All same elements
        int[] nums5 = {7, 7, 7, 7};
        int count5 = removeDuplicates(nums5);
        System.out.println("Test 5: " + Arrays.toString(Arrays.copyOfRange(nums5, 0, count5))); // [7]

        // Test 6: Negative numbers
        int[] nums6 = {-3, -1, -1, 0, 0, 2};
        int count6 = removeDuplicates(nums6);
        System.out.println("Test 6: " + Arrays.toString(Arrays.copyOfRange(nums6, 0, count6))); // [-3, -1, 0, 2]

        // Test 7: Two elements - duplicates
        int[] nums7 = {5, 5};
        int count7 = removeDuplicates(nums7);
        System.out.println("Test 7: " + Arrays.toString(Arrays.copyOfRange(nums7, 0, count7))); // [5]
    }

    private static int removeDuplicates(int[] nums) {
        int left = 0;

        for(int j=1; j<nums.length; j++) {
            if(nums[j] != nums[left]) {
                left++; //Move forward
                nums[left] = nums[j]; // Place new unique value
            }
        }

        return left+1;
    }
}
