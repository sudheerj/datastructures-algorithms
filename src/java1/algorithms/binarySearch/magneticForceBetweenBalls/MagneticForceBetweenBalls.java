package java1.algorithms.binarySearch.magneticForceBetweenBalls;

import java.util.Arrays;

public class MagneticForceBetweenBalls {
    //Sorting + binary search on distance space TC: O(log n) SC: O(1)
    private int maxDistance(int[] positions, int m) {
        Arrays.sort(positions);
        int left =0, right = positions[positions.length-1] - positions[0];

        while(left <= right) {
            int mid = left + (right -left)/2;

            if(canPlace(positions, m, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean canPlace(int[] positions, int m, int distance) {
        int balls = 1;
        int lastPlaced = positions[0];

        for(int i=1; i<positions.length; i++) {
            if(positions[i]-lastPlaced >=distance) {
                balls++;
                lastPlaced = positions[i];
            }

            if(balls >=m) {
                return true;
            }
        }

        return false;
    }
}
