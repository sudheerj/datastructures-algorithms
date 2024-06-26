package buySellStock;
//Greedy approach/Sliding window: TC:O(n), SC:O(1)

class BuySellStock {
    private static int maxProfit(int[] stockPrices) {
        if(stockPrices.length < 2) return 0;

        int maxProfit = 0, left=0;
        for(int right=1; right< stockPrices.length; right++) {
            if(stockPrices[right]>stockPrices[left]) {
                maxProfit = Math.max(maxProfit, stockPrices[right]-stockPrices[left]);
            } else {
                left = right;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {8,3,6,4,7,5};
        System.out.println(maxProfit(stockPrices));
    }
}