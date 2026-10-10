**Description:**
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

Find the maximum profit you can achieve. You may complete **at most two transactions**.

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

## Examples:
Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Total profit = 3 + 3 = 6.

Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

Example 4:

Input: prices = [1]
Output: 0
Explanation: Only one day, cannot complete any transaction.

**Algorithmic Steps**
This problem can be solved using multiple **dynamic programming** approaches:

### Approach 1: Recursive (Exponential Time)
1. Use a recursive function `dfs(idx, buy, cap)` where:
   - `idx`: current day index
   - `buy`: 1 if we can buy, 0 if we must sell or skip
   - `cap`: remaining transactions allowed (0, 1, or 2)
2. Base case: If `idx` reaches end of array or `cap` is 0, return 0
3. If `buy == 1`: Choose max of buying today or skipping
4. If `buy == 0`: Choose max of selling today or holding
5. Return maximum profit from all choices

### Approach 2: Memoization (Top-Down DP)
1. Same as recursive approach but cache results in 3D DP array `dp[idx][buy][cap]`
2. Check cache before computing, store result after computing
3. Significantly reduces redundant calculations

### Approach 3: Tabulation (Bottom-Up DP)
1. Create 3D DP array `dp[n+1][2][3]` where:
   - First dimension: days (0 to n)
   - Second dimension: buy state (0 or 1)
   - Third dimension: transaction capacity (0 to 2)
2. Fill array from last day backwards to day 0
3. For each state, compute maximum profit based on buy/sell decisions
4. Return `dp[0][1][2]` (start with ability to buy, 2 transactions allowed)

### Approach 4: Space Optimized DP
1. Observation: Only need current and next day's states
2. Use two 2D arrays instead of 3D array
3. Iterate backwards, maintaining only previous state
4. Reduces space from O(n) to O(1) for day dimension

### Approach 5: State Machine (Optimal)
1. Track 4 states: `buy1`, `sell1`, `buy2`, `sell2`
2. For each price:
   - `buy1`: max profit after first buy
   - `sell1`: max profit after first sell
   - `buy2`: max profit after second buy (using profit from first sell)
   - `sell2`: max profit after second sell
3. Update states sequentially in one pass
4. Return `sell2` as final answer

**Time and Space complexity:**

| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Recursive | O(2^n) | O(n) - recursion stack |
| Memoization | O(n × 2 × 3) = O(n) | O(n × 2 × 3) = O(n) |
| Tabulation | O(n × 2 × 3) = O(n) | O(n × 2 × 3) = O(n) |
| Space Optimized | O(n × 2 × 3) = O(n) | O(2 × 3) = O(1) |
| State Machine | O(n) | O(1) |

The **State Machine approach** is optimal with linear time and constant space.

## Related Topics
- Dynamic Programming
- State Machine
- Array
- Stock Trading Problems

## Implementation
- [Java Implementation](./BuySellStock3.java)
- [Python Implementation](../../../../python/algorithms/dynamicProgramming/buySellStock3/buy_sell_stock3.py)
- [JavaScript Implementation](../../../../javascript/algorithms/dynamicProgramming/buySellStock3/buySellStock3.js)
