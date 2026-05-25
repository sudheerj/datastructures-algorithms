package zeroArrayTransformation1;

public class ZeroArrayTransformation1 {

    // Difference array + prefix sum TC: O(n + q) SC: O(n)
    private static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        // Step 1: build diff array
        int[] diffArr = new int[n + 1];

        // Apply all queries in O(q)
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            diffArr[left]++;
            diffArr[right + 1]--;
        }

        // Step 2: build coverage using prefix sum; Step 3: feasibility check
        int currentCoverage = 0;
        for (int i = 0; i < n; i++) {
            currentCoverage += diffArr[i];
            if (currentCoverage < nums[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] numsArr = { { 1, 0, 1 }, { 4, 3, 2, 1 }, { 2, 0, 2 }, { 1, 2, 3, 4 }, { 3, 1, 2 } };
        int[][][] queriesArr = {
                { { 0, 2 } },
                { { 1, 3 }, { 0, 2 } },
                { { 0, 2 }, { 0, 2 } },
                { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 3, 3 } },
                { { 0, 1 }, { 1, 2 } }
        };
        boolean[] expected = { true, false, true, true, false };

        for (int t = 0; t < expected.length; t++) {
            boolean result = isZeroArray(numsArr[t], queriesArr[t]);
            String status = result == expected[t] ? "PASS" : "FAIL";
            System.out.printf("[%s] nums=%s result=%b expected=%b%n",
                    status, java.util.Arrays.toString(numsArr[t]), result, expected[t]);
        }
    }
}
