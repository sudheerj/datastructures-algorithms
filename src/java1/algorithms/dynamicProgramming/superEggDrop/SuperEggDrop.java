package java1.algorithms.dynamicProgramming.superEggDrop;

public class SuperEggDrop {
    static Integer[][] dp;

    // n = floors, k = eggs TC: O(k * n log n) SC: O(k * n)
    public static int superEggDrop(int n, int k) {
        dp = new Integer[k + 1][n + 1];
        return dfs(n, k);
    }

    private static int dfs(int floors, int eggs) {
        if (floors == 0 || floors == 1)
            return floors;
        if (eggs == 1)
            return floors;
        if (dp[eggs][floors] != null)
            return dp[eggs][floors];

        int low = 1, high = floors;
        int minAttempts = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int breakCase = dfs(mid - 1, eggs - 1); // egg breaks → check below
            int surviveCase = dfs(floors - mid, eggs); // egg survives → check above

            int attempts = 1 + Math.max(breakCase, surviveCase);
            minAttempts = Math.min(minAttempts, attempts);

            if (breakCase < surviveCase) {
                low = mid + 1; // move higher to reduce surviveCase
            } else {
                high = mid - 1; // move lower to reduce breakCase
            }
        }

        dp[eggs][floors] = minAttempts;
        return minAttempts;
    }

    public static void main(String[] args) {
        int[][] tests = {
                // {n (floors), k (eggs), expected}
                { 1, 1, 1 },
                { 2, 1, 2 },
                { 6, 2, 3 },
                { 10, 2, 4 },
                { 14, 3, 4 },
                { 2, 2, 2 },
        };

        for (int[] test : tests) {
            int n = test[0], k = test[1], expected = test[2];
            int result = superEggDrop(n, k);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] n=" + n + " k=" + k +
                    " result=" + result + " expected=" + expected);
        }
    }
}
