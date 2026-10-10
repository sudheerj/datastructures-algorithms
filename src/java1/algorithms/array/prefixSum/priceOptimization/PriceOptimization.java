package java1.algorithms.array.prefixSum.priceOptimization;

import java.util.ArrayList;
import java.util.List;

public class PriceOptimization {
    // Prefix sum + binary search: TC: O(n + q log n), auxiliary SC: O(n)
    public static List<Integer> priceOptimization(List<Integer> prices, List<Integer> pos, List<Integer> amounts) {
        int n = prices.size();

        // prefix[i] is the total price of items before index i.
        long[] prefix = new long[n + 1];
        for (int i = 0; i < prices.size(); i++) {
            prefix[i + 1] = prefix[i] + prices.get(i);
        }

        // Each query asks how many consecutive items from its 1-based position fit the
        // budget.
        List<Integer> results = new ArrayList<>();
        for (int q = 0; q < pos.size(); q++) {
            int start = pos.get(q) - 1;
            int amount = amounts.get(q);

            // Search for the furthest exclusive end index whose range sum stays within
            // budget.
            int left = start;
            int right = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                // Range [start, mid) costs prefix[mid] - prefix[start].
                long cost = prefix[mid] - prefix[start];

                if (cost <= amount) {
                    // This many items are affordable; try extending the range.
                    left = mid + 1;
                } else {
                    // The range is too expensive; shorten it.
                    right = mid - 1;
                }
            }
            // right is the last affordable exclusive end index.
            results.add(right - start);
        }

        return results;
    }

    public static void main(String[] args) {
        List<Integer> prices = List.of(2, 3, 1, 4, 2);
        List<Integer> positions = List.of(1, 2, 4, 5);
        List<Integer> budgets = List.of(5, 4, 10, 0);
        List<Integer> expected = List.of(2, 2, 2, 0);

        List<Integer> actual = priceOptimization(prices, positions, budgets);
        System.out.println("Test 1: expected=" + expected + ", actual=" + actual
                + (expected.equals(actual) ? " [PASS]" : " [FAIL]"));

        List<Integer> exactBudgetPrices = List.of(4, 2, 5);
        List<Integer> exactBudgetPositions = List.of(1, 2, 3);
        List<Integer> exactBudgets = List.of(6, 7, 5);
        List<Integer> exactBudgetExpected = List.of(2, 2, 1);
        List<Integer> exactBudgetActual = priceOptimization(
                exactBudgetPrices, exactBudgetPositions, exactBudgets);
        System.out.println("Test 2 (exact budget boundaries): expected=" + exactBudgetExpected
                + ", actual=" + exactBudgetActual
                + (exactBudgetExpected.equals(exactBudgetActual) ? " [PASS]" : " [FAIL]"));

        List<Integer> zeroPrices = List.of(0, 0, 3, 0);
        List<Integer> zeroPositions = List.of(1, 2, 3, 4);
        List<Integer> zeroBudgets = List.of(0, 0, 3, 0);
        List<Integer> zeroExpected = List.of(2, 1, 2, 1);
        List<Integer> zeroActual = priceOptimization(zeroPrices, zeroPositions, zeroBudgets);
        System.out.println("Test 3 (zero-priced items): expected=" + zeroExpected
                + ", actual=" + zeroActual
                + (zeroExpected.equals(zeroActual) ? " [PASS]" : " [FAIL]"));

        List<Integer> insufficientBudgetPrices = List.of(5, 7, 2);
        List<Integer> insufficientBudgetPositions = List.of(1, 2, 3);
        List<Integer> insufficientBudgets = List.of(0, 6, 1);
        List<Integer> insufficientExpected = List.of(0, 0, 0);
        List<Integer> insufficientActual = priceOptimization(
                insufficientBudgetPrices, insufficientBudgetPositions, insufficientBudgets);
        System.out.println("Test 4 (budget cannot buy starting item): expected=" + insufficientExpected
                + ", actual=" + insufficientActual
                + (insufficientExpected.equals(insufficientActual) ? " [PASS]" : " [FAIL]"));
    }
}
