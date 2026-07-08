package java1.algorithms.interval.twoBestNonOverlappingEvents;

import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    //Sort + Binary search + suffix maximum  TC: O(n log n) for sorting + O(n log n) for binary search -> O(n log n) SC: O(n)
    private static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0]-b[0]);

        int n = events.length;

        //maxValue[i] = Maximum value from i to end
        int[] maxValue = new int[n];
        maxValue[n-1] = events[n-1][2];

        for(int i=n-2; i>=0; i--) {
            maxValue[i] = Math.max(maxValue[i+1], events[i][2]);
        }

        int maxSum = 0;

        for(int i = 0; i<n; i++) {
            int currentValue = events[i][2];

            int left = i + 1, right = n -1, next = n;

            //Binary search for first non-overlapping 
            while(left <= right) {
                int mid = left +(right -left)/2;

                if(events[mid][0] > events[i][1]) {
                    next = mid;
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            }

            if(next < n) {
                currentValue += maxValue[next];
            }

            maxSum = Math.max(currentValue, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[][] events1 = {
                {1, 3, 2},
                {4, 5, 2},
                {2, 4, 3}
        };
        System.out.println("Test 1: " + maxTwoEvents(events1)); // 4

        int[][] events2 = {
                {1, 3, 2},
                {4, 5, 2},
                {1, 5, 5}
        };
        System.out.println("Test 2: " + maxTwoEvents(events2)); // 5

        int[][] events3 = {
                {1, 5, 3},
                {1, 5, 1},
                {6, 6, 5}
        };
        System.out.println("Test 3: " + maxTwoEvents(events3)); // 8

        int[][] events4 = {
                {1, 2, 4},
                {3, 4, 3},
                {5, 6, 5}
        };
        System.out.println("Test 4: " + maxTwoEvents(events4)); // 9

        int[][] events5 = {
                {1, 10, 5},
                {2, 3, 100},
                {4, 5, 50},
                {11, 12, 10}
        };
        System.out.println("Test 5: " + maxTwoEvents(events5)); // 150

        int[][] events6 = {
                {1, 2, 100}
        };
        System.out.println("Test 6: " + maxTwoEvents(events6)); // 100

        int[][] events7 = {
                {1, 5, 4},
                {2, 6, 7},
                {3, 7, 10}
        };
        System.out.println("Test 7: " + maxTwoEvents(events7)); // 10

        int[][] events8 = {
                {1, 2, 10},
                {3, 4, 20},
                {5, 6, 30},
                {7, 8, 40}
        };
        System.out.println("Test 8: " + maxTwoEvents(events8)); // 70
    }
}
