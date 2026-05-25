package mergeSortedArray;

import java.util.Arrays;

public class MergeSortedArray {

    // Three pointers from the back TC: O(m + n) SC: O(1)
    private static int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        return nums1;
    }

    public static void main(String[] args) {
        int[][][] cases = {
                { { 1, 2, 3, 0, 0, 0 }, { 3 }, { 2, 5, 6 }, { 3 }, { 1, 2, 2, 3, 5, 6 } },
                { { 1 }, { 1 }, {}, { 0 }, { 1 } },
                { { 0 }, { 0 }, { 1 }, { 1 }, { 1 } },
                { { 4, 5, 6, 0, 0, 0 }, { 3 }, { 1, 2, 3 }, { 3 }, { 1, 2, 3, 4, 5, 6 } },
                { { 1, 2, 4, 5, 6, 0 }, { 5 }, { 3 }, { 1 }, { 1, 2, 3, 4, 5, 6 } },
        };

        for (int[][] tc : cases) {
            int[] nums1 = tc[0].clone();
            int m = tc[1][0];
            int[] nums2 = tc[2];
            int n = tc[3][0];
            int[] expected = tc[4];

            int[] result = mergeSortedArray(nums1, m, nums2, n);
            String status = Arrays.equals(result, expected) ? "PASS" : "FAIL";
            System.out.printf("[%s] result=%s expected=%s%n",
                    status, Arrays.toString(result), Arrays.toString(expected));
        }
    }
}
