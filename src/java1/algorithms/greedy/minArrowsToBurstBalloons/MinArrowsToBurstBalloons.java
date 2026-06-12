package java1.algorithms.greedy.minArrowsToBurstBalloons;

import java.util.Arrays;

public class MinArrowsToBurstBalloons {
    private int findMinArrowShots(int[][] points) {
        //Sort by start time TC: O(n log n) SC: O(n)
        Arrays.sort(points, (a, b) -> a[0]-b[0]);

        int arrows = points.length;
        int overlapEnd = points[0][1];

        for(int i=1; i<points.length; i++) {
            if(points[i][0] <= overlapEnd) {
                arrows--;
                overlapEnd = Math.min(overlapEnd, points[i][1]);
            } else {
                overlapEnd = points[i][1];
            }
        }

        return arrows;
    }
}
