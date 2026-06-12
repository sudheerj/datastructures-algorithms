package java1.algorithms.greedy.maximumUnitsOnTruck;

import java.util.Arrays;

public class MaximumUnitsOnTruck {
    private static int maximumUnits(int[][] boxTypes, int truckSize) {
        //Sort by units per box in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1]-a[1]);
        int totalUnits = 0;

        for(int[] boxType: boxTypes) {
            int boxes = boxType[0];
            int unitsPerBox = boxType[1];

            int boxesToTake = Math.min(truckSize, boxes);

            totalUnits += boxesToTake * unitsPerBox;
            truckSize -= boxesToTake;

            if(truckSize == 0) {
                break;
            }
        }

        return totalUnits;
    }

public static void main(String[] args) {
        int[][] boxTypes1 = {
            {1, 3},
            {2, 2},
            {3, 1}
        };
        int truckSize1 = 4;

        int[][] boxTypes2 = {
            {5, 10},
            {2, 5},
            {4, 7},
            {3, 9}
        };
        int truckSize2 = 10;

        System.out.println("Test Case 1:");
        System.out.println("Maximum Units = " +
                maximumUnits(boxTypes1, truckSize1)); // 8

        System.out.println("\nTest Case 2:");
        System.out.println("Maximum Units = " +
                maximumUnits(boxTypes2, truckSize2)); // 91
    }
}
