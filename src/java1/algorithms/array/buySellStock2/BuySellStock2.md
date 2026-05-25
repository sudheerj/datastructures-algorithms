**Problem statement:** Given an integer array `prices` where `prices[i]` is the price of a stock on the `i`-th day, find the maximum profit you can achieve. You may buy and sell the stock multiple times, but you may not hold more than one share at a time.

## Examples:
```
Input: prices = [7,1,5,3,6,4]    Output: 7
Input: prices = [1,2,3,4,5]      Output: 4
Input: prices = [7,6,4,3,1]      Output: 0
```

**Algorithmic Steps (Greedy — accumulate positive daily gains):**
1. Initialize `maxProfit = 0`.
2. Iterate from index `1` to end.
3. If `prices[i] - prices[i-1] > 0`, add that difference to `maxProfit`.
4. Return `maxProfit`.

**Algorithmic Steps (Peak-Valley):**
1. Initialize `maxProfit = 0`, `i = 0`.
2. While `i < prices.length - 1`:
   - Advance `i` while `prices[i] >= prices[i+1]` to find the next **valley**.
   - Advance `i` while `prices[i] <= prices[i+1]` to find the next **peak**.
   - Add `peak - valley` to `maxProfit`.
3. Return `maxProfit`.

**Time and Space complexity:**

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Greedy (positive daily gains) | O(n) | O(1) |
| Peak-Valley | O(n) | O(1) |
