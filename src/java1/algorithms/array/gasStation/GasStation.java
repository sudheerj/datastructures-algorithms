package java1.algorithms.array.gasStation;

import java.util.Arrays;

public class GasStation {
    // Greedy  TC: O(n) SC: O(1)
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int total = 0;
        int res = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][][] tests = {
            {{1, 2, 3, 4, 5}, {3, 4, 5, 1, 2}},       // expected 3
            {{2, 3, 4}, {3, 4, 3}},                     // expected -1
            {{5, 1, 2, 3, 4}, {4, 4, 1, 5, 1}},        // expected 4
            {{3, 3, 4}, {3, 4, 4}},                     // expected -1
            {{1, 2}, {2, 1}},                            // expected 1
        };
        int[] expected = {3, -1, 4, -1, 1};

        for (int i = 0; i < tests.length; i++) {
            int result = canCompleteCircuit(tests[i][0], tests[i][1]);
            String status = result == expected[i] ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected[i]);
        }
    }
}
