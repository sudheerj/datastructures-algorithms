package java1.algorithms.math.maxPointsOnLine;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
    //Using slope frequency map TC: O(n^2) SC: O(n)
    private static int maxPointsOnLine(int[][] points) {
        int maxPoints = 1;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> count = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                Double slope = getSlope(points[i], points[j]);
                if (slope == -0.0)
                    slope = 0.0;
                count.put(slope, count.getOrDefault(slope, 0) + 1);
                maxPoints = Math.max(maxPoints, count.get(slope) + 1);
            }
        }

        return maxPoints;
    }

    private static double getSlope(int[] point1, int[] point2) {
        if (point2[0] == point1[0]) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (point2[1] - point1[1]) / (point2[0] - point1[0]);
    }

    public static void main(String[] args) {
        int[][] points1 = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        int r1 = maxPointsOnLine(points1);
        System.out.println(
                "Test 1 - 3 collinear diagonal: " + (r1 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=3");

        int[][] points2 = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 5 } };
        int r2 = maxPointsOnLine(points2);
        System.out.println("Test 2 - 3 collinear one outlier: " + (r2 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r2
                + " expected=3");

        int[][] points3 = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } };
        int r3 = maxPointsOnLine(points3);
        System.out.println("Test 3 - 4 collinear horizontal: " + (r3 == 4 ? "[PASS]" : "[FAIL]") + " result=" + r3
                + " expected=4");

        int[][] points4 = { { 0, 0 }, { 2, 1 }, { 4, 3 } };
        int r4 = maxPointsOnLine(points4);
        System.out.println("Test 4 - no 3 collinear fractional slopes: " + (r4 == 2 ? "[PASS]" : "[FAIL]") + " result="
                + r4 + " expected=2");

        int[][] points5 = { { 0, 0 } };
        int r5 = maxPointsOnLine(points5);
        System.out
                .println("Test 5 - single point: " + (r5 == 1 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=1");
    }
}
