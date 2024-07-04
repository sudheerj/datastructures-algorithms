package java1.algorithms.interval.nonOverlappingIntervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    //Greedy approach: TC: O(n logn) + O(n), SC: O(1)
    private static int eraseOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int minRemove = 0;
        int prevEnd = intervals[0][1];

        for(int i=1; i< intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start >= prevEnd) {
                prevEnd = end;
            } else {
                minRemove++;
                prevEnd = Math.min(prevEnd, end);
            }
        }
        return minRemove;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2},{2, 3},{3, 4}, {1, 3}};
        System.out.println(eraseOverlappingIntervals(intervals));
    }
}
