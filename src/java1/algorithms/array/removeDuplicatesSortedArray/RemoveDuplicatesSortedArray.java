package removeDuplicatesSortedArray;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
    // Two pointers (previous element comparison) TC: O(n) SC: O(1)
    private static int removeDuplicates2(int[] nums) {
        int left = 1;

        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right - 1]) {
                nums[left++] = nums[right];
            }
        }

        return left;
    }

    // Two pointers TC: O(n) SC: O(1)
    private static int removeDuplicates1(int[] nums) {
        int left = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[left]) {
                left++;
                nums[left] = nums[j];
            }
        }

        return left + 1;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                { 1, 1, 2 },
                { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 },
                { 1, 2, 3, 4, 5 },
                { 1 },
                { 7, 7, 7, 7 }
        };
        int[] expectedCounts = { 2, 5, 5, 1, 1 };
        int[][] expectedArrays = {
                { 1, 2 },
                { 0, 1, 2, 3, 4 },
                { 1, 2, 3, 4, 5 },
                { 1 },
                { 7 }
        };

        System.out.println("--- removeDuplicates1 (left pointer) ---");
        for (int i = 0; i < inputs.length; i++) {
            int[] nums = inputs[i].clone();
            int k = removeDuplicates1(nums);
            boolean pass = k == expectedCounts[i] && Arrays.equals(Arrays.copyOfRange(nums, 0, k), expectedArrays[i]);
            System.out.println((pass ? "[PASS]" : "[FAIL]") + " k=" + k + " array="
                    + Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
        }

        System.out.println("--- removeDuplicates2 (prev element comparison) ---");
        for (int i = 0; i < inputs.length; i++) {
            int[] nums = inputs[i].clone();
            int k = removeDuplicates2(nums);
            boolean pass = k == expectedCounts[i] && Arrays.equals(Arrays.copyOfRange(nums, 0, k), expectedArrays[i]);
            System.out.println((pass ? "[PASS]" : "[FAIL]") + " k=" + k + " array="
                    + Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
        }
    }
}
