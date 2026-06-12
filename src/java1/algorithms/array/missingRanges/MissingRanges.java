package java1.algorithms.array.missingRanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    //Gap detection using linear scan TC: O(n) SC: O(1)
    private static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> missingRanges = new ArrayList<>();

        long nextExpected = lower;
        for(int num: nums) {
            if(num > nextExpected) {
                missingRanges.add(Arrays.asList((int)nextExpected, num-1));
            }
            nextExpected = (long)num + 1;
        }

        //Find missing ranges after the last number
        if(nextExpected <=upper) {
            missingRanges.add(Arrays.asList((int)nextExpected, upper));
        }

        return missingRanges;
    }

    public static void main(String[] args) {

        // LeetCode example
        System.out.println(
            findMissingRanges(
                new int[]{0, 1, 3, 50, 75},
                0,
                99
            )
        );
        // [[2, 2], [4, 49], [51, 74], [76, 99]]

        // Empty array
        System.out.println(
            findMissingRanges(
                new int[]{},
                1,
                5
            )
        );
        // [[1, 5]]

        // No missing numbers
        System.out.println(
            findMissingRanges(
                new int[]{1, 2, 3, 4, 5},
                1,
                5
            )
        );
        // []

        // Missing numbers at the beginning
        System.out.println(
            findMissingRanges(
                new int[]{3, 4, 5},
                1,
                5
            )
        );
        // [[1, 2]]

        // Missing numbers at the end
        System.out.println(
            findMissingRanges(
                new int[]{1, 2, 3},
                1,
                5
            )
        );
        // [[4, 5]]

        // Single missing number
        System.out.println(
            findMissingRanges(
                new int[]{1, 3},
                1,
                3
            )
        );
        // [[2, 2]]

        // Integer.MAX_VALUE edge case
        System.out.println(
            findMissingRanges(
                new int[]{Integer.MAX_VALUE},
                Integer.MAX_VALUE,
                Integer.MAX_VALUE
            )
        );
        // []
    }
}
