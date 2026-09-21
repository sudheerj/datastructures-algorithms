package java1.algorithms.greedy.purchaseOptimization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//TC: O(n log n) SC: O(n) due to sorting
public class PurchaseOptimization {
    public static int maximizeToys(List<Integer> prices, int budget) {
        Collections.sort(prices);

        int count = 0;
        for(int price: prices) {
            if(budget > price) {
                budget -= price;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(1, 12, 5, 111, 200, 1000, 10);
        System.out.println(maximizeToys(prices, 50));
    }
}
