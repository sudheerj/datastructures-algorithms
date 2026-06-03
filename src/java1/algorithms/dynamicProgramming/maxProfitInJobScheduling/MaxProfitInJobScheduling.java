package java1.algorithms.dynamicProgramming.maxProfitInJobScheduling;

import java.util.Arrays;

public class MaxProfitInJobScheduling {
    int n;

    // Recursive with start times sorting TC: O(2^n) SC: O(n)
    private int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        return dfs(0, jobs);
    }

    private int dfs(int i, int[][] jobs) {
        if (i == n)
            return 0;

        int skip = dfs(i + 1, jobs);

        int next = i + 1;
        while (next < n && jobs[i][1] > jobs[next][0])
            next++;

        int take = jobs[i][2] + dfs(next, jobs);

        return Math.max(skip, take);
    }

    int[] dp;

    // Top-down memoization TC: O(n^2) SC: O(n)
    private int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs1(0, jobs);
    }

    private int dfs1(int i, int[][] jobs) {
        if (i == n)
            return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int skip = dfs1(i + 1, jobs);
        int next = i + 1;
        while (next < n && jobs[i][1] > jobs[next][0])
            next++;
        int take = jobs[i][2] + dfs1(next, jobs);

        return dp[i] = Math.max(skip, take);
    }

    // DP + endtime sorting + Binary search TC: O(n log n) SC: O(n)
    private int jobScheduling3(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int include = jobs[i][2];

            int prev = binarySearch(i, jobs);

            if (prev != -1) {
                include += dp[prev];
            }
            int exclude = dp[i - 1];

            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }

    private int binarySearch(int idx, int[][] jobs) {
        int low = 0, high = idx - 1, index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (jobs[mid][1] <= jobs[idx][0]) {
                index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        MaxProfitInJobScheduling solution = new MaxProfitInJobScheduling();

        // Test cases: [startTime[], endTime[], profit[], expected]
        Object[][] tests = {
                { new int[] { 1, 2, 3, 3 }, new int[] { 3, 4, 5, 6 }, new int[] { 50, 10, 40, 70 }, 120 },
                { new int[] { 1, 2, 3, 4, 6 }, new int[] { 3, 5, 10, 6, 9 }, new int[] { 20, 20, 100, 70, 60 }, 150 },
                { new int[] { 1, 1, 1 }, new int[] { 2, 3, 4 }, new int[] { 5, 6, 4 }, 6 },
                { new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 3, 4, 5, 6 }, new int[] { 1, 2, 3, 4, 5 }, 15 },
                { new int[] { 1 }, new int[] { 2 }, new int[] { 50 }, 50 },
                { new int[] { 6, 15, 7, 11, 1, 3, 16, 2 }, new int[] { 19, 18, 19, 16, 10, 8, 19, 8 },
                        new int[] { 2, 9, 1, 19, 5, 7, 3, 19 }, 41 },
                { new int[] { 4, 2, 4, 8, 2 }, new int[] { 5, 5, 5, 10, 8 }, new int[] { 1, 2, 8, 10, 4 }, 18 },
                { new int[] { 1, 2, 2, 3 }, new int[] { 2, 5, 3, 4 }, new int[] { 3, 4, 1, 2 }, 7 },
                { new int[] { 1, 3, 6, 8 }, new int[] { 2, 5, 7, 9 }, new int[] { 5, 12, 4, 10 }, 31 },
                { new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 3, 4, 5, 6, 7, 8 }, new int[] { 5, 6, 5, 4, 11, 2 }, 21 }
        };

        System.out.println("Maximum Profit in Job Scheduling - Test Results:");
        System.out.println("=".repeat(100));

        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            int[] startTime = (int[]) tests[i][0];
            int[] endTime = (int[]) tests[i][1];
            int[] profit = (int[]) tests[i][2];
            int expected = (int) tests[i][3];

            // Test all approaches (skip recursive for large inputs)
            int result1 = (startTime.length < 10) ? solution.jobScheduling1(startTime, endTime, profit) : expected;
            int result2 = solution.jobScheduling2(startTime, endTime, profit);
            int result3 = solution.jobScheduling3(startTime, endTime, profit);

            boolean pass = (result2 == expected && result3 == expected);

            // Debug: print all results if test fails
            if (!pass) {
                System.out.printf("Test %2d FAIL | Start: %s%n", i + 1, Arrays.toString(startTime));
                System.out.printf("  End: %s, Profit: %s%n", Arrays.toString(endTime), Arrays.toString(profit));
                System.out.printf("  Recursive: %d, Memo: %d, DP+BS: %d | Expected: %d%n",
                        result1, result2, result3, expected);
            } else {
                System.out.printf(
                        "Test %2d | Start: %-25s | End: %-25s | Profit: %-25s | Output: %3d | Expected: %3d | %s%n",
                        i + 1, Arrays.toString(startTime), Arrays.toString(endTime), Arrays.toString(profit),
                        result2, expected, "PASS");
                passed++;
            }
        }

        System.out.println("=".repeat(100));
        System.out.printf("Tests Passed: %d/%d%n", passed, tests.length);
    }
}
