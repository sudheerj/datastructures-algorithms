package findOccuranceElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOccuranceElement {
    //preprocessing indices TC: O(n) SC: O(1)
    private static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> pos = new ArrayList<>();

        for(int i=0; i<x; i++) {
            if(nums[i] == x) {
                pos.add(x);
            }
        }

        int[] ans = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            int k = queries[i];

            if(k<=pos.size()) {
                ans[i] = pos.get(k-1);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }

public static void main(String[] args) {

        // Test 1
        System.out.println("Test 1");
        int[] nums1 = {1, 3, 1, 7, 1, 2};
        int[] queries1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(
                occurrencesOfElement(nums1, queries1, 1)));
        // Expected: [0, 2, 4, -1]

        // Test 2
        System.out.println("Test 2");
        int[] nums2 = {5, 5, 5, 5};
        int[] queries2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(
                occurrencesOfElement(nums2, queries2, 5)));
        // Expected: [0, 1, 2, 3, -1]

        // Test 3
        System.out.println("Test 3");
        int[] nums3 = {2, 4, 6, 8};
        int[] queries3 = {1, 2};
        System.out.println(Arrays.toString(
                occurrencesOfElement(nums3, queries3, 5)));
        // Expected: [-1, -1]

        // Test 4
        System.out.println("Test 4");
        int[] nums4 = {9};
        int[] queries4 = {1};
        System.out.println(Arrays.toString(
                occurrencesOfElement(nums4, queries4, 9)));
        // Expected: [0]

        // Test 5
        System.out.println("Test 5");
        int[] nums5 = {1, 2, 3, 4, 5};
        int[] queries5 = {1};
        System.out.println(Arrays.toString(
                occurrencesOfElement(nums5, queries5, 3)));
        // Expected: [2]

        // Test 6
        System.out.println("Test 6");
        int[] nums6 = {7, 1, 7, 2, 7, 3, 7};
        int[] queries6 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(
                occurrencesOfElement(nums6, queries6, 7)));
        // Expected: [0, 2, 4, 6, -1]
    }
}
