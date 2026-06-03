package java1.algorithms.math.twoCitySchedulingCost;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwoCitySchedulingCost {
    // Greedy approach with cost diff TC: O(n logn) SC: O(n)
    private static int twoCitySchedulingCost(int[][] costs) {
        List<int[]> costDiffs = new ArrayList<>();
        for (int[] cost : costs) {
            costDiffs.add(new int[] { cost[1] - cost[0], cost[0], cost[1] });
        }

        costDiffs.sort(Comparator.comparingInt(a -> a[0]));

        int totalMinCost = 0;
        for (int i = 0; i < costDiffs.size(); i++) {
            if (i < costDiffs.size() / 2) {
                totalMinCost += costDiffs.get(i)[2]; // send to city B (smallest diff = most benefit going to B)
            } else {
                totalMinCost += costDiffs.get(i)[1]; // send to city A
            }
        }

        return totalMinCost;
    }

    public static void main(String[] args) {
        int[][] costs1 = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
        int r1 = twoCitySchedulingCost(costs1);
        System.out.println("Test 1 - [[10,20],[30,200],[400,50],[30,20]]: " + (r1 == 110 ? "[PASS]" : "[FAIL]")
                + " result=" + r1 + " expected=110");

        int[][] costs2 = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
        int r2 = twoCitySchedulingCost(costs2);
        System.out.println(
                "Test 2 - 6 people: " + (r2 == 1859 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=1859");

        int[][] costs3 = { { 1, 2 }, { 3, 4 } };
        int r3 = twoCitySchedulingCost(costs3);
        System.out.println(
                "Test 3 - [[1,2],[3,4]]: " + (r3 == 5 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=5");

        int[][] costs4 = { { 100, 1 }, { 1, 100 } };
        int r4 = twoCitySchedulingCost(costs4);
        System.out.println(
                "Test 4 - [[100,1],[1,100]]: " + (r4 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=2");

        int[][] costs5 = { { 10, 10 }, { 10, 10 } };
        int r5 = twoCitySchedulingCost(costs5);
        System.out.println(
                "Test 5 - [[10,10],[10,10]]: " + (r5 == 20 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=20");
    }
}
