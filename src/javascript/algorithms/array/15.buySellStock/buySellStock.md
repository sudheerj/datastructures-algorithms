**Description:**
Given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day. The profit can be maximized by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, just return 0.

### Examples
Example 1:

Input: prices = [8, 3, 6, 4, 7, 5]
Output: 4

Example 2:
Input: prices = [7, 6, 5, 4, 3, 2, 1]
Output: 0

**Algorithmic Steps**
This problem is solved with the help of sliding window approach to calculate the maximum profit(as known as **greedy algorithm**). The algorithmic approach can be summarized as follows:

1. Write a preliminary case by returning profit as `0` if the number of stock prices in the array are less than  2.

2. Initialize `maxProfit` variable to `0` to indicate maximum profit achieved for buying and selling the stock at different days. 

3. Initialize left pointer(i.e,`left`) to `0`, which denotes the buying stock index.

4. Iterate over the input stock prices and compare the current stock price(i.e, `stockPrices[right]`) with previous day stock price(i.e, `stockPrices[left]`). If the current stock price is higher, calculate the maximum profit between previous maxProfit and current profit.

5. If the current stock price is lower than previous stock price, consider the current stock price as buying stock with the help of their index pointers(i.e, `left = right`). 

6. Return `maxProfit` which represents best time(or max proft scenario) to buy and sell stock prices.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of stock prices. This is because we are traversing the array at most once. 
Here, we don't use any additional datastructure other than two pointers. Hence, the space complexity will be `O(1)`.