**Problem statement:**
Given a triangle array, find the minimum path sum from top to bottom. At each step you may move to an **adjacent number** of the row below — from index `i` you can go to `i` or `i+1` in the next row.

## Examples:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
(Path: 2 → 3 → 5 → 1)

Input: triangle = [[-10]]
Output: -10

Input: triangle = [[-1],[2,3],[1,-1,-3]]
Output: -5
(Path: -1 → 3 → -3)

**Algorithmic Steps**

### Approach 1 — Top-down Memoization `triangle1`
1. Initialize `memo[n][]` where each row is filled with `Integer.MAX_VALUE`.
2. Call `dfs(0, 0)`.
3. If `r >= n`, return `0` (past the bottom).
4. If `memo[r][c]` is set, return it.
5. `memo[r][c] = triangle[r][c] + min(dfs(r+1,c), dfs(r+1,c+1))`.
6. Return `memo[0][0]`.

### Approach 2 — Bottom-up DP `triangle2`
1. Create `dp[n][n]`, copy the last row of triangle into `dp[n-1]`.
2. For `r` from `n-2` down to `0`, for each `c`:
   `dp[r][c] = triangle[r][c] + min(dp[r+1][c], dp[r+1][c+1])`.
3. Return `dp[0][0]`.

### Approach 3 — Bottom-up In-place `triangle3`
1. Modify the triangle in-place starting from second-to-last row upward.
2. For `r` from `n-2` down to `0`, for each `c`:
   `triangle[r][c] = triangle[r][c] + min(triangle[r+1][c], triangle[r+1][c+1])`.
3. Return `triangle[0][0]`.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Top-down Memo | O(n²) | O(n²) |
| Bottom-up DP | O(n²) | O(n²) |
| In-place | O(n²) | O(1) |
