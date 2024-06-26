function buySellStock(stockPrices) {
    if(stockPrices.length < 2) return 0;

    let maxProfit = left = 0;

    for (let right = 0; right < stockPrices.length; right++) {
        if(stockPrices[right] > stockPrices[left]) {
            maxProfit = Math.max(maxProfit, stockPrices[right] - stockPrices[left]);
        } else {
            left = right;
        } 
    }

    return maxProfit;
}

let stockPrices1 = [8, 3, 6, 4, 7, 5];
let stockPrices2 = [7, 6, 5, 4, 3, 2, 1];

console.log(maxProfit(stockPrices1));
console.log(maxProfit(stockPrices2));

