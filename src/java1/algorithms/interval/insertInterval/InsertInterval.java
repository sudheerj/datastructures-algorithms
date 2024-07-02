package java1.algorithms.interval.insertInterval;
import java.util.*;

public class InsertInterval {
    //TC:O(n) SC:O(n)
    private static int[][] insertInterval(int[] newInterval, int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        boolean isIntervalInserted = false;

        for(int[] interval: intervals) {
            if(newInterval[1] < interval[0]) {
                result.add(newInterval);
                result.add(interval);
                isIntervalInserted = true;
            } else if(isIntervalInserted || (interval[1] < newInterval[0])) {
                result.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if(!isIntervalInserted) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[] newInterval = {4,8};
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        System.out.println(Arrays.deepToString(insertInterval(newInterval, intervals)));
    }
}
