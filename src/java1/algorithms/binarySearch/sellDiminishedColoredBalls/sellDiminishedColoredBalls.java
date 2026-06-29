package java1.algorithms.binarySearch.sellDiminishedColoredBalls;

import java.util.Arrays;

public class sellDiminishedColoredBalls {
    private static final long MOD = 1_000_000_007;

    // Binary search + greedy TC: O(n log M) M= max inventory value SC: O(1)
    private static int maxProfit(int[] inventory, int orders) {
        int max = 0;

        for (int coloredInventory : inventory) {
            max = Math.max(max, coloredInventory);
        }

        int left = 0, right = max;
        // binary search to find the largestThreshold such that balls sold >= orders
        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            long balls = 0;

            for (int coloredInventory : inventory) {
                if (coloredInventory > mid) {
                    balls += coloredInventory - mid;
                }
            }

            if (balls >= orders) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        int threshod = left;
        long profit = 0;
        long ballsSold = 0;

        for (int coloredInventory : inventory) {
            if (coloredInventory > threshod) {
                ballsSold += coloredInventory - threshod;
                profit += sum(threshod + 1, coloredInventory);
                profit = profit % MOD;
            }
        }

        long extraBalls = ballsSold - orders;

        profit = (profit - (extraBalls * (threshod + 1)) + MOD) % MOD;

        return (int) profit;
    }

    private static long sum(long low, long high) {
        return (high * (high + 1) / 2 - ((low - 1) * low) / 2) % MOD;
    }

    public static void main(String[] args) {

        int[] inventory;
        int orders;

        inventory = new int[] { 2, 5 };
        orders = 4;
        System.out.println(Arrays.toString(inventory) + ", orders = " + orders);
        System.out.println("Profit = " + maxProfit(inventory, orders));
        System.out.println();

        inventory = new int[] { 3, 5 };
        orders = 6;
        System.out.println(Arrays.toString(inventory) + ", orders = " + orders);
        System.out.println("Profit = " + maxProfit(inventory, orders));
        System.out.println();

        inventory = new int[] { 5 };
        orders = 3;
        System.out.println(Arrays.toString(inventory) + ", orders = " + orders);
        System.out.println("Profit = " + maxProfit(inventory, orders));
        System.out.println();

        inventory = new int[] { 5, 5 };
        orders = 3;
        System.out.println(Arrays.toString(inventory) + ", orders = " + orders);
        System.out.println("Profit = " + maxProfit(inventory, orders));
        System.out.println();

        inventory = new int[] { 5, 5 };
        orders = 4;
        System.out.println(Arrays.toString(inventory) + ", orders = " + orders);
        System.out.println("Profit = " + maxProfit(inventory, orders));
        System.out.println();

        inventory = new int[] { 8, 6 };
        orders = 5;
        System.out.println(Arrays.toString(inventory) + ", orders = " + orders);
        System.out.println("Profit = " + maxProfit(inventory, orders));
        System.out.println();

        inventory = new int[] { 1000000000 };
        orders = 2;
        System.out.println(Arrays.toString(inventory) + ", orders = " + orders);
        System.out.println("Profit = " + maxProfit(inventory, orders));
    }
}
