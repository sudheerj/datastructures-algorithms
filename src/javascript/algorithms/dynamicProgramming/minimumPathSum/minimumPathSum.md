**Problem statement:**
Given an `m x n` grid filled with non-negative integers, find a path from the top-left corner to the bottom-right corner that **minimizes the sum** of all numbers along the path. You can only move **right** or **down** at each step.

## Examples:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
(Path: 1 → 3 → 1 → 1 → 1)

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
(Path: 1 → 2 → 3 → 6)

Input: grid = [[1]]
Output: 1

**Algorithmic Steps**

### Approach 1 — Top-down Memoization `minPathSum1`
1. Start DFS from `(0, 0)`.
2. If out of bounds, return `Infinity`.
3. If at `(rows-1, cols-1)`, return `grid[r][c]`.
4. Check memo Map with key `"r,c"`.
5. `memo[r,c] = grid[r][c] + min(dfs(r+1,c), dfs(r,c+1))`.

### Approach 2 — Bottom-up DP `minPathSum2`
1. Create `dp[rows+1][cols+1]` filled with `Infinity`.
2. Set `dp[rows-1][cols] = 0`.
3. For `r` from `rows-1` to `0`, `c` from `cols-1` to `0`:
   `dp[r][c] = grid[r][c] + min(dp[r+1][c], dp[r][c+1])`.
4. Return `dp[0][0]`.

### Approach 3 — Space-Optimized DP `minPathSum3`
1. `dp = new Array(cols+1).fill(Infinity)`, set `dp[cols-1] = 0`.
2. For each row `r` from bottom to top, each col `c` from right to left:
   `dp[c] = grid[r][c] + min(dp[c], dp[c+1])`.
3. Return `dp[0]`.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Top-down Memo | O(m×n) | O(m×n) |
| Bottom-up DP | O(m×n) | O(m×n) |
| Space-Optimized | O(m×n) | O(n) |
