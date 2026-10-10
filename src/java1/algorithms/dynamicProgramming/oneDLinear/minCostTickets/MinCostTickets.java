package java1.algorithms.dynamicProgramming.oneDLinear.minCostTickets;

public class MinCostTickets {
    // Top-down approach TC: O(n ^ 2) SC: O(n)
    public static int minCostTickets(int[] days, int[] cost) {
        Integer[] dp = new Integer[days.length];
        return dfs(0, days, cost, dp);
    }

    public static int dfs(int i, int[] days, int[] cost, Integer[] dp) {
        // already covered
        if (i == days.length) {
            return 0;
        }

        // already calculated
        if (dp[i] != null) {
            return dp[i];
        }

        // 1 day pass
        int j = i + 1;
        int oneDay = cost[0] + dfs(j, days, cost, dp);

        // 7-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        int sevenDay = cost[1] + dfs(j, days, cost, dp);

        // 30-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        int thirtyDay = cost[2] + dfs(j, days, cost, dp);

        dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));

        return dp[i];
    }

    public static void main(String[] args) {
        int[][] travelDays = {
                { 1, 4, 6, 7, 8, 20 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 },
                {},
                { 5 }
        };
        int[][] ticketCosts = {
                { 2, 7, 15 },
                { 2, 7, 15 },
                { 2, 7, 15 },
                { 2, 7, 15 }
        };
        int[] expectedCosts = { 11, 17, 0, 2 };

        for (int i = 0; i < travelDays.length; i++) {
            int actual = minCostTickets(travelDays[i], ticketCosts[i]);
            String result = actual == expectedCosts[i] ? "PASS" : "FAIL";
            System.out.println("Test " + (i + 1) + ": expected=" + expectedCosts[i]
                    + ", actual=" + actual + " [" + result + "]");
        }
    }
}
