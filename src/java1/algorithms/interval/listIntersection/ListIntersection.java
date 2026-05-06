package java1.algorithms.interval.listIntersection;

import java.util.ArrayList;
import java.util.List;

public class ListIntersection {
    //Two pointers TC:O(n+m) SC: O(1)
    private static int[][] listIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int firstStart = firstList[i][0], firstEnd = firstList[i][1];
            int secondStart = secondList[j][0], secondEnd = secondList[j][1];

            int start = Math.max(firstStart, secondStart);
            int end = Math.min(firstEnd, secondEnd);

            // Verify valid intersection
            if (start <= end) {
                result.add(new int[] { start, end });
            }

            // Move the pointer with smaller end
            if (firstEnd < secondEnd) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private static void printResult(int[][] result) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] interval : result) {
            sb.append("[").append(interval[0]).append(",").append(interval[1]).append("]");
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // Test 1: General case with multiple overlaps
        int[][] first1 = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] second1 = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        printResult(listIntersection(first1, second1)); // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

        // Test 2: Simple partial overlap
        int[][] first2 = { { 0, 2 }, { 5, 10 } };
        int[][] second2 = { { 1, 5 }, { 8, 12 } };
        printResult(listIntersection(first2, second2)); // [[1,2],[5,5],[8,10]]

        // Test 3: No overlaps
        int[][] first3 = { { 0, 2 }, { 5, 7 } };
        int[][] second3 = { { 3, 4 }, { 8, 10 } };
        printResult(listIntersection(first3, second3)); // []

        // Test 4: One list is empty
        int[][] first4 = { { 0, 5 } };
        int[][] second4 = {};
        printResult(listIntersection(first4, second4)); // []

        // Test 5: Complete containment
        int[][] first5 = { { 1, 10 } };
        int[][] second5 = { { 2, 3 }, { 4, 6 } };
        printResult(listIntersection(first5, second5)); // [[2,3],[4,6]]

        // Test 6: Same intervals
        int[][] first6 = { { 1, 5 } };
        int[][] second6 = { { 1, 5 } };
        printResult(listIntersection(first6, second6)); // [[1,5]]
    }
}
