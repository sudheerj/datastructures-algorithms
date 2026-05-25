package buySellStock2;

public class BuySellStock2 {
    // Using greedy (accumulate positive daily gains) TC: O(n) SC: O(1)
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    // Using peak-valley approach TC: O(n) SC: O(1)
    private static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            int valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            int peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] t1 = { 7, 1, 5, 3, 6, 4 };
        int[] t2 = { 1, 2, 3, 4, 5 };
        int[] t3 = { 7, 6, 4, 3, 1 };
        int[] t4 = { 1, 2, 1, 3, 1, 4 };
        int[] t5 = { 2, 1, 2, 0, 1 };
        int e1 = 7, e2 = 4, e3 = 0, e4 = 6, e5 = 2;

        // Approach 1: greedy
        int r1 = maxProfit(t1);
        System.out
                .println("Test 1 (greedy): " + (r1 == e1 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=" + e1);
        int r2 = maxProfit(t2);
        System.out
                .println("Test 2 (greedy): " + (r2 == e2 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=" + e2);
        int r3 = maxProfit(t3);
        System.out
                .println("Test 3 (greedy): " + (r3 == e3 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=" + e3);
        int r4 = maxProfit(t4);
        System.out
                .println("Test 4 (greedy): " + (r4 == e4 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=" + e4);
        int r5 = maxProfit(t5);
        System.out
                .println("Test 5 (greedy): " + (r5 == e5 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=" + e5);

        // Approach 2: peak-valley
        int r6 = maxProfit2(t1);
        System.out.println(
                "Test 1 (peak-valley): " + (r6 == e1 ? "[PASS]" : "[FAIL]") + " result=" + r6 + " expected=" + e1);
        int r7 = maxProfit2(t2);
        System.out.println(
                "Test 2 (peak-valley): " + (r7 == e2 ? "[PASS]" : "[FAIL]") + " result=" + r7 + " expected=" + e2);
        int r8 = maxProfit2(t3);
        System.out.println(
                "Test 3 (peak-valley): " + (r8 == e3 ? "[PASS]" : "[FAIL]") + " result=" + r8 + " expected=" + e3);
        int r9 = maxProfit2(t4);
        System.out.println(
                "Test 4 (peak-valley): " + (r9 == e4 ? "[PASS]" : "[FAIL]") + " result=" + r9 + " expected=" + e4);
        int r10 = maxProfit2(t5);
        System.out.println(
                "Test 5 (peak-valley): " + (r10 == e5 ? "[PASS]" : "[FAIL]") + " result=" + r10 + " expected=" + e5);
    }
}
