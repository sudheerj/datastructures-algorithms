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
2. If out of bounds, return `Integer.MAX_VALUE` (invalid path).
3. If at `(rows-1, cols-1)`, return `grid[r][c]` (reached target).
4. If `memo[r][c]` is set, return it.
5. Recurse down `(r+1, c)` and right `(r, c+1)`, take the min, add `grid[r][c]`.
6. Cache and return the result.

### Approach 2 — Bottom-up DP `minPathSum2`
1. Create `dp[rows+1][cols+1]`, initialize all to `Integer.MAX_VALUE`.
2. Set sentinel `dp[rows-1][cols] = 0` (just right of the last cell).
3. Iterate `r` from `rows-1` to `0`, `c` from `cols-1` to `0`.
4. `dp[r][c] = grid[r][c] + min(dp[r+1][c], dp[r][c+1])`.
5. Return `dp[0][0]`.

### Approach 3 — Space-Optimized DP `minPathSum3`
1. Keep a 1D `dp[cols+1]`, initialize all to `Integer.MAX_VALUE`.
2. Set `dp[cols-1] = 0` (sentinel).
3. Iterate `r` from `rows-1` to `0`, `c` from `cols-1` to `0`.
4. `dp[c] = grid[r][c] + min(dp[c], dp[c+1])` — `dp[c]` holds the row-below value, `dp[c+1]` holds the right value.
5. Return `dp[0]`.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Top-down Memo | O(m×n) | O(m×n) |
| Bottom-up DP | O(m×n) | O(m×n) |
| Space-Optimized | O(m×n) | O(n) |
