package java1.algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    
    public static int[][] mergeIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add intervals that come before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged interval
        result.add(newInterval);

        // Add intervals that come after newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };

        int[][] mergedIntervals = mergeIntervals(intervals, newInterval);

        // Print the merged intervals
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

}

// Time Complexity - O(n)
// Space Complexity - O(n)
