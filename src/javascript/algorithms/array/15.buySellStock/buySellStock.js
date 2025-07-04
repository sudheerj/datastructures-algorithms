function buySellStock(stockPrices) {
    if(stockPrices.length < 2) return 0;

    let maxProfit = 0;
    let left = 0, right = 1;

    while(right < stockPrices.length) {
        if(stockPrices[right] > stockPrices[left]) {
            maxProfit = Math.max(maxProfit, stockPrices[right] - stockPrices[left]);
        } else {
            left = right; // // Found a lower price to buy a stock
        } 
        right++;
    }

    return maxProfit;
}

// Test case 1: Standard increasing/decreasing
console.log(buySellStock([8, 3, 6, 4, 7, 5])); // Expected: 4
// Test case 2: No profit possible (monotonically decreasing)
console.log(buySellStock([7, 6, 5, 4, 3, 2, 1])); // Expected: 0
// Test case 3: Increasing prices only
console.log(buySellStock([1, 2, 3, 4, 5, 6])); // Expected: 5
// Test case 4: Single price (not enough data)
console.log(buySellStock([7])); // Expected: 0
// Test case 5: Empty array
console.log(buySellStock([])); // Expected: 0
// Test case 6: Flat prices
console.log(buySellStock([5, 5, 5, 5, 5])); // Expected: 0
