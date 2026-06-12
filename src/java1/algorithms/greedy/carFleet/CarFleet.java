package java1.algorithms.greedy.carFleet;

import java.util.Arrays;

public class CarFleet {
    //Sorting + Greedy scan(Right-> Left) TC: O(n) SC: O(n)
    private int carFleet(int target, int[] position, int[] speed) {
        int n= position.length;
        int[][] cars = new int[n][2]; //{position, time}

        for(int i=0; i< n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (target - position[i])/speed[i];
        }

        //Sort by positions in descending order
        Arrays.sort(cars, (a, b) -> b[0]-a[0]);

        int fleets = 0;
        int maxTime = 0;

        for(int i=0; i<n; i++) {
            if(cars[i][1] > maxTime) {
                fleets++;
                maxTime = cars[i][1];
            }
        }

        return fleets;
    }
}
