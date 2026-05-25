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
1. Use a `memo` dict keyed by `(r, c)`.
2. Base case: `r >= n` → return `0`.
3. `memo[(r,c)] = t[r][c] + min(dfs(r+1,c), dfs(r+1,c+1))`.

### Approach 2 — Bottom-up DP `triangle2`
1. Create `dp[n][n]`, copy last row of triangle into `dp[n-1]`.
2. For `r` from `n-2` down to `0`, for each `c`:
   `dp[r][c] = t[r][c] + min(dp[r+1][c], dp[r+1][c+1])`.
3. Return `dp[0][0]`.

### Approach 3 — In-place `triangle3`
1. Copy the triangle to avoid mutating input.
2. For `r` from `n-2` down to `0`, for each `c`:
   `tri[r][c] += min(tri[r+1][c], tri[r+1][c+1])`.
3. Return `tri[0][0]`.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Top-down Memo | O(n²) | O(n²) |
| Bottom-up DP | O(n²) | O(n²) |
| In-place | O(n²) | O(n) copy |
