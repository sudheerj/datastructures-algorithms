**Description:**
Given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day. The profit can be maximized by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, just return 0.

### Examples
Example 1:

Input: prices = [7, 1, 5, 3, 6, 4]
Output: 5 (buy at 1, sell at 6)

Example 2:
Input: prices = [7, 6, 4, 3, 1]
Output: 0 (no profit possible)

**Algorithmic Steps**
This problem is solved with a one-pass approach by tracking the minimum price seen so far (as known as **greedy algorithm**). The algorithmic approach can be summarized as follows:

1. If the input `prices` array is empty, return `0` as no transaction is possible.

2. Initialize `min_price` to the first element of the array (i.e, `prices[0]`), representing the lowest stock price seen so far.

3. Initialize `max_profit` variable to `0` to indicate the maximum profit achieved for buying and selling the stock at different days.

4. Iterate over the input stock prices starting from the second element. For each price:
   - Update `min_price` to the minimum of the current `min_price` and the current price (i.e, `min(min_price, price)`).
   - Calculate the current profit as the difference between the current price and `min_price` (i.e, `price - min_price`).
   - Update `max_profit` to the maximum of the current `max_profit` and the current profit (i.e, `max(max_profit, profit)`).

5. Return `max_profit` which represents the best time (or max profit scenario) to buy and sell stock prices.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of stock prices. This is because we are traversing the array at most once.
Here, we don't use any additional datastructure other than two variables. Hence, the space complexity will be `O(1)`.
