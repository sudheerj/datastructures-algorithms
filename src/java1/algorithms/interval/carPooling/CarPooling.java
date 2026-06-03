package java1.algorithms.interval.carPooling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CarPooling {
    //Difference Array:- Range update + prefix sum(sweep line) TC: O(n+1000) SC: O(1000) n= number of trips, 1000 locations
    private boolean carPooling1(int[][] trips, int capacity) {
        int[] occupancy = new int[1001];

        for(int[] trip: trips) {
            int people = trip[0];
            int from = trip[1];
            int to = trip[2];

            occupancy[from] += people;
            occupancy[to] -= people;
        }

        int currPassengers = 0;
        //prefix sum
        for(int i=0; i<=1000; i++) {
            currPassengers += occupancy[i];

            if(currPassengers > capacity) {
                return false;
            }
        }

        return true;
    }

    //Sorting + Min heap(active intervals) TC: O(n log n) SC: O(n)
    private boolean carPooling2(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1]-b[1]);

        // {dropOff -> passengers}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        int currPassengers = 0;

        for(int[] trip: trips) {

            while (!pq.isEmpty() && pq.peek()[0] <= trip[1]) {
                currPassengers -= pq.poll()[1];
            }

            //add passengers
            currPassengers += trip[0];

            //Less capacity
            if(currPassengers > capacity) {
                return false;
            }

            pq.add(new int[]{trip[2], trip[0]});
        }

        return true;
    }

    //Event processing(sweep line) TC: O(n logn) SC: O(n)
    private boolean carPooling3(int[][] trips, int capacity) {
        List<int[]> events = new ArrayList<>();

        for(int[] trip: trips) {
            events.add(new int[]{trip[1], trip[0]}); //pickup
            events.add(new int[]{trip[2], -trip[0]}); //drop-off
        }

        Collections.sort(events, (a, b) ->  a[0]-b[0]);

        int currPassengers = 0;

        for(int[] event: events) {
            currPassengers += event[1];

            if(currPassengers > capacity) {
                return false;
            }
        }

        return true;
    }

    //Bruteforce TC: O(n * 1000) SC: O(1000)
    private boolean carPooling4(int[][] trips, int capacity) {
        int[] occupancy = new int[1001];

        for(int[] trip: trips) {

            int people = trip[0];
            int from = trip[1];
            int to = trip[2];

            for(int j=from; j< to; j++) {
                occupancy[j] += people;

                if(occupancy[j] > capacity) {
                    return false;
                }
            }
        }

        return true;
    }
    // Utility to deep copy a 2D array
    private static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }

    public static void main(String[] args) {
        CarPooling sol = new CarPooling();
        int[][][] tests = {
            { {2,1,5}, {3,3,7} }, // cap=4, false
            { {2,1,5}, {3,3,7} }, // cap=5, true
            { {3,2,7}, {3,7,9}, {8,3,9} }, // cap=11, true
            { {3,2,7}, {3,7,9}, {8,3,9} }, // cap=10, false
            { {2,1,5}, {3,5,7} }, // cap=3, true
            { {2,1,5}, {3,5,7} }, // cap=2, false
            { {9,0,1}, {3,3,7} }, // cap=10, true
        };
        int[] capacities = {4,5,11,10,3,2,10};
        boolean[] expected = {false,true,true,false,true,false,true};

        System.out.println("Testing carPooling1 (difference array):");
        for (int i = 0; i < tests.length; i++) {
            int[][] input = deepCopy(tests[i]);
            boolean result = sol.carPooling1(input, capacities[i]);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%s, Expected=%s [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }

        System.out.println("\nTesting carPooling2 (min heap):");
        for (int i = 0; i < tests.length; i++) {
            int[][] input = deepCopy(tests[i]);
            boolean result = sol.carPooling2(input, capacities[i]);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%s, Expected=%s [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }

        System.out.println("\nTesting carPooling3 (event sweep):");
        for (int i = 0; i < tests.length; i++) {
            int[][] input = deepCopy(tests[i]);
            boolean result = sol.carPooling3(input, capacities[i]);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%s, Expected=%s [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }

        System.out.println("\nTesting carPooling4 (bruteforce):");
        for (int i = 0; i < tests.length; i++) {
            int[][] input = deepCopy(tests[i]);
            boolean result = sol.carPooling4(input, capacities[i]);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%s, Expected=%s [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }
    }
}
