**Algorithmic Steps**
This problem is solved with the help of sliding window approach to calculate the maximum profit(as known as **greedy algorithm**). The algorithmic approach can be summarized as follows:

1. Write a preliminary case by returning profit as `0` if the number of stock prices are less than 2.

2. Initialize `maxProfit` variable as 0 to indicate maximum profit for buying and selling the stock at different days. 

3. Initialize `left` variable(left pointer) as 0, which denotes the buying stock index.

4. Iterate over the input stock prices and compare the current stock price(i.e, `stockPrices[right]`) with previous day stock price(i.e, `stockPrices[left]`). If the current stock price is higher, calculate the maximum profit between previous maxProfit and current stock difference.

5. If the current stock price is lower than previous stock price, consider the current stock price as buying stock with the help of their indexes in an array(i.e, `left = right`). 

6. Return `maxProfit` which represents best time(or max proft scenario) to buy and sell stock prices.


**Time and Space complexity:**
This algorithm has a time complexity of O(n), where n is the number of stock prices. This is because we are traversing the array at most once. 
Here, we don't use any additional datastructure other than two pointers. Hence, the space complexity will be O(1).