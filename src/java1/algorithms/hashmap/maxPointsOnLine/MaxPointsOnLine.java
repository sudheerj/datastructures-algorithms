package java1.algorithms.hashmap.maxPointsOnLine;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
    //TC: O(n^2) OC: O(n)
    private static int maxPointsOnLine(int[][] points) {
        int result = 1;

        for(int i=0; i<points.length; i++) {
            Map<Double, Integer> countMap = new HashMap<>();

            for(int j=i+1; j<points.length; j++) {
                double slope = getSlope(points[i], points[j]);

                countMap.put(slope, countMap.getOrDefault(slope, 0)+1);
                result = Math.max(result, countMap.get(slope)+1);
            }
        }
        return result;
    }

    private static double getSlope(int[] p1, int[] p2) {
        if(p1[0] == p2[0]) {
            return Double.POSITIVE_INFINITY;
        }

        return (double)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

    public static void main(String[] args) {
        // Test 1: all three points collinear
        System.out.println("Test 1: " + maxPointsOnLine(new int[][]{{1,1},{2,2},{3,3}}) + " (expected 3)");

        // Test 2: LeetCode example — diagonal (1,4)(2,3)(3,2)(4,1) gives 4
        System.out.println("Test 2: " + maxPointsOnLine(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}) + " (expected 4)");

        // Test 3: single point
        System.out.println("Test 3: " + maxPointsOnLine(new int[][]{{0,0}}) + " (expected 1)");

        // Test 4: horizontal line
        System.out.println("Test 4: " + maxPointsOnLine(new int[][]{{0,0},{1,0},{2,0}}) + " (expected 3)");

        // Test 5: vertical line
        System.out.println("Test 5: " + maxPointsOnLine(new int[][]{{0,0},{0,1},{0,2}}) + " (expected 3)");
    }
}
