package zeroArrayTransformation2;

public class ZeroArrayTransformation2 {

    // Binary search + difference array + prefix sum TC: O((n+q) log q) SC: O(n)
    private static int minZeroArray(int[] nums, int[][] queries) {
        int q = queries.length;
        int left = 0, right = q, answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isZeroArray(nums, queries, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private static boolean isZeroArray(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diffArr = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            diffArr[l]++;
            diffArr[r + 1]--;
        }

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
        int[][] numsArr = { { 2, 0, 2 }, { 4, 3, 2, 1 }, { 1, 2, 3, 4 }, { 0, 0, 0 }, { 1, 2, 3 } };
        int[][][] queriesArr = {
                { { 0, 2 }, { 0, 2 }, { 1, 1 } },
                { { 1, 3 }, { 0, 2 } },
                { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 3, 3 } },
                { { 0, 1 }, { 1, 2 } },
                { { 0, 2 }, { 1, 2 }, { 2, 2 } }
        };
        int[] expected = { 2, -1, 4, 0, 3 };

        for (int t = 0; t < expected.length; t++) {
            int result = minZeroArray(numsArr[t], queriesArr[t]);
            String status = result == expected[t] ? "PASS" : "FAIL";
            System.out.printf("[%s] nums=%s result=%d expected=%d%n",
                    status, java.util.Arrays.toString(numsArr[t]), result, expected[t]);
        }
    }
}
