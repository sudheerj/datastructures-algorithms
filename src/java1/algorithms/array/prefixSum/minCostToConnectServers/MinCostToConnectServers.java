package java1.algorithms.array.prefixSum.minCostToConnectServers;

import java.util.Arrays;

public class MinCostToConnectServers {
    // PrefixSum + Array traversal => TC: O(n + m) SC: O(n)
    public static int[] minCostToConnectServers(int[] capacity, int[] fromServers, int[] toServers) {
        int n = capacity.length;
        int m = fromServers.length;

        int[] results = new int[m];

        if (n == 1) {
            return results;
        }

        // 1. Find closest servers for each server
        int[] closest = new int[n];
        closest[0] = 1;
        closest[n - 1] = n - 2;
        for (int i = 1; i < n - 1; i++) {
            int leftGap = capacity[i] - capacity[i - 1];
            int rightGap = capacity[i + 1] - capacity[i];

            if (leftGap < rightGap) {
                closest[i] = i - 1;
            } else {
                closest[i] = i + 1;
            }
        }

        // 2. Prefix when moving towards right
        int[] right = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int normalCost = capacity[i + 1] - capacity[i];
            int cost;

            if (closest[i] == i + 1) {
                cost = 1;
            } else {
                cost = normalCost;
            }
            right[i + 1] = right[i] + cost;
        }

        // 3.Prefix when moving towards left
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            int normalCost = capacity[i] - capacity[i - 1];
            int cost;
            if (closest[i] == i - 1) {
                cost = 1;
            } else {
                cost = normalCost;
            }
            left[i] = left[i - 1] + cost;
        }

        // 4. Answer queries
        for (int q = 0; q < m; q++) {
            int from = fromServers[q];
            int to = toServers[q];
            if (from == to) {
                results[q] = 0;
            } else if (from < to) {
                // Moving towards right
                results[q] = (int) (right[to] - right[from]);
            } else {
                results[q] = (int) (left[from] - left[to]);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[][] capacities = {
                { 2, 7, 9, 12, 13 },
                { 1, 4, 10, 11 },
                { 8 }
        };
        int[][] fromServers = {
                { 0, 1, 4, 3, 2, 0 },
                { 0, 3, 1, 2 },
                { 0, 0 }
        };
        int[][] toServers = {
                { 4, 3, 0, 1, 2, 0 },
                { 3, 0, 2, 2 },
                { 0, 0 }
        };
        int[][] expected = {
                { 6, 4, 10, 4, 0, 0 },
                { 8, 8, 6, 0 },
                { 0, 0 }
        };

        for (int i = 0; i < capacities.length; i++) {
            int[] actual = minCostToConnectServers(capacities[i], fromServers[i], toServers[i]);
            System.out.println("Test " + (i + 1) + ": expected=" + Arrays.toString(expected[i])
                    + ", actual=" + Arrays.toString(actual)
                    + (Arrays.equals(actual, expected[i]) ? " [PASS]" : " [FAIL]"));
        }
    }
}
