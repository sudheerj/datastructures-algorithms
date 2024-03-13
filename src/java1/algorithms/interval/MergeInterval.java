package java1.algorithms.interval;

import java.util.*;

public class MergeInterval {
    // TC: O(n login + n) SC: O(n)
    private static int[][] mergeInterval(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int i=1; i< intervals.length; i++) {
            int[] currInterval = intervals[i];
            int[] lastMergedInterval = result.get(result.size()-1);
            if(lastMergedInterval[1] < currInterval[0]) {
                result.add(currInterval);
            } else {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currInterval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(mergeInterval(intervals)));
    }
}
