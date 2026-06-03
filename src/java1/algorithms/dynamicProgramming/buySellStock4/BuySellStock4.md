**Description:**
You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i`th day, and an integer `k`.

Find the maximum profit you can achieve. You may complete **at most k transactions**: i.e. you may buy at most `k` times and sell at most `k` times.

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

## Examples:
Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Total profit = 4 + 3 = 7.

Example 3:

Input: k = 2, prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Total profit = 3 + 3 = 6.

Example 4:

Input: k = 2, prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

**Algorithmic Steps**
This problem can be solved using multiple **dynamic programming** approaches:

### Approach 1: Recursive (Exponential Time)
1. Use a recursive function `dfs(idx, buy, cap)` where:
   - `idx`: current day index
   - `buy`: 1 if we can buy, 0 if we must sell or skip
   - `cap`: remaining transactions allowed (0 to k)
2. Base case: If `idx` reaches end of array or `cap` is 0, return 0
3. If `buy == 1`: Choose max of buying today or skipping
4. If `buy == 0`: Choose max of selling today or holding
5. Return maximum profit from all choices

### Approach 2: Memoization (Top-Down DP)
1. Same as recursive approach but cache results in 3D DP array `dp[idx][buy][cap]`
2. Check cache before computing, store result after computing
3. Significantly reduces redundant calculations

### Approach 3: Tabulation (Bottom-Up DP)
1. Create 3D DP array `dp[n+1][2][k+1]` where:
   - First dimension: days (0 to n)
   - Second dimension: buy state (0 or 1)
   - Third dimension: transaction capacity (0 to k)
2. Fill array from last day backwards to day 0
3. For each state, compute maximum profit based on buy/sell decisions
4. Return `dp[0][1][k]` (start with ability to buy, k transactions allowed)

### Approach 4: Space Optimized DP
1. Observation: Only need current and next day's states
2. Use two 2D arrays instead of 3D array
3. Iterate backwards, maintaining only previous state
4. Reduces space from O(n) to O(1) for day dimension

### Approach 5: Greedy + DP (Optimal for Large k)
1. Key insight: When k >= n/2, we can make as many transactions as we want
2. For large k, use greedy approach: capture every profitable price increase
3. For small k, fall back to space-optimized DP approach
4. This optimization reduces time complexity to O(n) when k is large

**Time and Space complexity:**

| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Recursive | O(2^n) | O(n) - recursion stack |
| Memoization | O(n × 2 × k) | O(n × 2 × k) |
| Tabulation | O(n × 2 × k) | O(n × 2 × k) |
| Space Optimized | O(n × 2 × k) | O(2 × k) = O(k) |
| Greedy + DP | O(n) or O(n × k) | O(1) or O(k) |

The **Greedy + DP approach** is optimal, adapting to the value of k for best performance.

**Key Insight:**
This problem generalizes Buy and Sell Stock III (which has k=2) to any value of k. When k >= n/2 (where n is the number of days), the problem becomes equivalent to "unlimited transactions" since you can capture every profitable price increase.

## Related Topics
- Dynamic Programming
- Array
- Stock Trading Problems

## Implementation
- [Java Implementation](./BuySellStock4.java)
- [Python Implementation](../../../../python/algorithms/dynamicProgramming/buySellStock4/buy_sell_stock4.py)
- [JavaScript Implementation](../../../../javascript/algorithms/dynamicProgramming/buySellStock4/buySellStock4.js)
