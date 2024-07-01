package java1.algorithms.interval.mergeInterval;

import java.util.*;

public class MergeInterval {
    // TC: O(n log n) + O(n) => O(n log n) SC: O(n)
    private static int[][] mergeInterval(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);

        for(int i=1; i< intervals.length; i++) {
            int[] currInterval = intervals[i];
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size()-1);
            if(lastMergedInterval[1] < currInterval[0]) {
                mergedIntervals.add(currInterval);
            } else {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currInterval[1]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,5},{5,8}};

        System.out.println(Arrays.deepToString(mergeInterval(intervals1)));
        System.out.println(Arrays.deepToString(mergeInterval(intervals2)));
    }
}
