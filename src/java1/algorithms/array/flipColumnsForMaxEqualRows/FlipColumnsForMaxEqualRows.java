package java1.algorithms.array.flipColumnsForMaxEqualRows;

import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaxEqualRows {
    // Normalize rows with hashing TC: O(m * n) SC: O(m * n)
    private static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();

            // normalize row
            for (int num : row) {
                // if row starts with 1, flip logically
                if (row[0] == 1) {
                    sb.append(1 - num);
                } else {
                    sb.append(num);
                }
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        int maxRows = 0;
        for (int count : map.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }

    public static void main(String[] args) {
        int r1 = maxEqualRowsAfterFlips(new int[][] { { 0, 1 }, { 1, 1 } });
        System.out.println("Test 1: " + (r1 == 1 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=1");

        int r2 = maxEqualRowsAfterFlips(new int[][] { { 0, 1 }, { 1, 0 } });
        System.out.println("Test 2: " + (r2 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=2");

        int r3 = maxEqualRowsAfterFlips(new int[][] { { 0, 0, 0 }, { 0, 0, 1 }, { 1, 1, 0 } });
        System.out.println("Test 3: " + (r3 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=2");

        int r4 = maxEqualRowsAfterFlips(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 1, 0, 1, 1 } });
        System.out.println("Test 4: " + (r4 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=2");

        int r5 = maxEqualRowsAfterFlips(new int[][] { { 0, 0, 1, 1 }, { 1, 1, 0, 0 }, { 0, 0, 1, 0 } });
        System.out.println("Test 5: " + (r5 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=2");
    }
}
