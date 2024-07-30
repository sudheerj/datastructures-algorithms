function buySellStock(stockPrices) {
    if(stockPrices.length < 2) return 0;

    let maxProfit = left = 0;
    let right = 1;

    while(right < stockPrices.length) {
        if(stockPrices[right] > stockPrices[left]) {
            maxProfit = Math.max(maxProfit, stockPrices[right] - stockPrices[left]);
        } else {
            left = right;
        } 
        right++;
    }

    return maxProfit;
}

let stockPrices1 = [8, 3, 6, 4, 7, 5];
let stockPrices2 = [7, 6, 5, 4, 3, 2, 1];

console.log(buySellStock(stockPrices1));
console.log(buySellStock(stockPrices2));

