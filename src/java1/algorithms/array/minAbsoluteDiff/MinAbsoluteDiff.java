package minAbsoluteDiff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsoluteDiff {
    // Sort + scan adjacent — TC: O(n log n) SC: O(n)
    private static List<List<Integer>> minAbsDifference(int[] nums) {

        // Sort the array to get min with adjacent numbers
        Arrays.sort(nums);

        // find minDiff
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i] - nums[i - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        // collect pairs with minDiff
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == minDiff) {
                result.add(List.of(nums[i - 1], nums[i]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> r1 = minAbsDifference(new int[] { 4, 2, 1, 3 });
        String e1 = "[[1, 2], [2, 3], [3, 4]]";
        System.out.println(
                "Test 1: " + (r1.toString().equals(e1) ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=" + e1);

        List<List<Integer>> r2 = minAbsDifference(new int[] { 1, 3, 6, 10, 15 });
        String e2 = "[[1, 3]]";
        System.out.println(
                "Test 2: " + (r2.toString().equals(e2) ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=" + e2);

        List<List<Integer>> r3 = minAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 });
        String e3 = "[[-14, -10], [19, 23], [23, 27]]";
        System.out.println(
                "Test 3: " + (r3.toString().equals(e3) ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=" + e3);

        List<List<Integer>> r4 = minAbsDifference(new int[] { 1, 2, 3 });
        String e4 = "[[1, 2], [2, 3]]";
        System.out.println(
                "Test 4: " + (r4.toString().equals(e4) ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=" + e4);

        List<List<Integer>> r5 = minAbsDifference(new int[] { -5, 0, 5 });
        String e5 = "[[-5, 0], [0, 5]]";
        System.out.println(
                "Test 5: " + (r5.toString().equals(e5) ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=" + e5);
    }
}
