package java1.algorithms.greedy.wiggleSort;

import java.util.Arrays;

public class WiggleSort {
    //Greedy algo by adjusting current position repeatedly using local information TC: O(n) SC: O(1)
    private static void wiggleSort(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            if((i%2 == 1 && nums[i] < nums[i-1]) || (i%2 == 0 && nums[i] > nums[i-1])) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[][] tests = {
            {3, 5, 2, 1, 6, 4},
            {1, 2, 3, 4, 5, 6},
            {6, 5, 4, 3, 2, 1},
            {1, 3, 2, 4, 5},
            {4, 5, 5, 6},
            {1},
            {2, 1},
            {1, 2},
            {10, 90, 49, 2, 1, 5, 23}
        };

        for (int[] nums : tests) {
            System.out.println("Before: " + Arrays.toString(nums));
            wiggleSort(nums);
            System.out.println("After : " + Arrays.toString(nums));
            System.out.println();
        }
    }    
}
