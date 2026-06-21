package java1.algorithms.array.twoPointerApproach.summaryRanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
   //Two pointer approach TC: O(n) SC: O(1)(excluding output)
   private static List<String> summaryRanges(int[] nums) {
        List<String> rangeArray = new ArrayList<>();
        int n = nums.length;

        int i = 0;
        while(i < n) {
            int start = nums[i];

            while(i+1 < n && nums[i+1] == nums[i]+1) {
               i++;
            }

            int end = nums[i];

            if(start == end) {
               rangeArray.add(String.valueOf(start));
            } else {
               rangeArray.add(start +" -> " +end);
            }

            i++;
        }
        return rangeArray;
   }

public static void main(String[] args) {

        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output: " + summaryRanges(nums1));
        System.out.println();

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output: " + summaryRanges(nums2));
        System.out.println();

        int[] nums3 = {};
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("Output: " + summaryRanges(nums3));
        System.out.println();

        int[] nums4 = {5};
        System.out.println("Input : " + Arrays.toString(nums4));
        System.out.println("Output: " + summaryRanges(nums4));
        System.out.println();

        int[] nums5 = {1, 2, 3, 4, 5};
        System.out.println("Input : " + Arrays.toString(nums5));
        System.out.println("Output: " + summaryRanges(nums5));
        System.out.println();

        int[] nums6 = {1, 3, 5, 7};
        System.out.println("Input : " + Arrays.toString(nums6));
        System.out.println("Output: " + summaryRanges(nums6));
        System.out.println();

        int[] nums7 = {1, 2, 3, 7, 8, 10, 11, 12};
        System.out.println("Input : " + Arrays.toString(nums7));
        System.out.println("Output: " + summaryRanges(nums7));
        System.out.println();

        int[] nums8 = {-5, -4, -3, 0, 2, 3, 4};
        System.out.println("Input : " + Arrays.toString(nums8));
        System.out.println("Output: " + summaryRanges(nums8));
        System.out.println();

        int[] nums9 = {-2, -1, 0, 1, 3};
        System.out.println("Input : " + Arrays.toString(nums9));
        System.out.println("Output: " + summaryRanges(nums9));
        System.out.println();

        int[] nums10 = {1, 100, 200, 201, 202, 500};
        System.out.println("Input : " + Arrays.toString(nums10));
        System.out.println("Output: " + summaryRanges(nums10));
        System.out.println();
    }
}
