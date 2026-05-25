package java1.algorithms.greedy.nextPermutation;

import java.util.Arrays;

public class NextPermutation {
    // Greedy + array manipulation TC: O(n) SC: O(1)
    private static int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step1: Find pivot(first decreasing element from right)
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step2: If pivot exists, find next larger element with in suffix(after pivot
        // section) and swap with it
        if (i >= 0) {
            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        // Step3: Reverse the suffix
        reverse(nums, i + 1, n - 1);
        return nums;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[][][] tests = {
                { { 1, 2, 3 }, { 1, 3, 2 } },
                { { 3, 2, 1 }, { 1, 2, 3 } },
                { { 1, 1, 5 }, { 1, 5, 1 } },
                { { 1, 3, 2 }, { 2, 1, 3 } },
                { { 2, 3, 1 }, { 3, 1, 2 } },
        };

        for (int i = 0; i < tests.length; i++) {
            int[] result = nextPermutation(tests[i][0].clone());
            int[] expected = tests[i][1];
            String status = Arrays.equals(result, expected) ? "PASS" : "FAIL";
            System.out.println(status + " test " + (i + 1) + ": result=" + Arrays.toString(result) + " expected="
                    + Arrays.toString(expected));
        }
    }
}
