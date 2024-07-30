package buySellStock;
//Greedy approach/Sliding window: TC:O(n), SC:O(1)

class BuySellStock {
    private static int buySellStock(int[] stockPrices) {
        if(stockPrices.length < 2) return 0;

        int maxProfit = 0, left=0, right = 1;
        while(right< stockPrices.length) {
            if(stockPrices[right]>stockPrices[left]) {
                maxProfit = Math.max(maxProfit, stockPrices[right]-stockPrices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices1 = {8,3,6,4,7,5};
        System.out.println(buySellStock(stockPrices1));
        int[] stockPrices2 = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(buySellStock(stockPrices2));
    }
}