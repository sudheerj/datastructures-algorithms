**Problem statement:**
Given an `n x n` integer matrix, find the minimum sum of any **falling path**. A falling path starts at any element in the first row and chooses one element from each row. The next row's choice must be in the same or adjacent column (column ± 1).

## Examples:
Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
(Path: 1 → 5 → 7  or  1 → 4 → 8)

Input: matrix = [[-19,57],[-40,-5]]
Output: -59
(Path: -19 → -40)

Input: matrix = [[1]]
Output: 1

**Algorithmic Steps**

### Approach 1 — Top-down Memoization `minFallingPathSum1`
1. Initialize `cache[n][n]` filled with `Integer.MIN_VALUE` as sentinel.
2. Try every starting column `c` in row 0, take the minimum of `dfs(0, c)`.
3. In `dfs(r, c)`:
   - If `r == n`, return `0` (past last row).
   - If `c < 0 || c >= n`, return `Integer.MAX_VALUE` (out of bounds).
   - If cached, return cached value.
   - `cache[r][c] = matrix[r][c] + min(dfs(r+1,c-1), dfs(r+1,c), dfs(r+1,c+1))`.

### Approach 2 — Bottom-up In-place `minFallingPathSum2`
1. Iterate rows from `r = 1` to `n-1`.
2. For each cell `(r, c)`:
   - `left  = matrix[r-1][c-1]` if `c > 0`, else `MAX_VALUE`
   - `mid   = matrix[r-1][c]`
   - `right = matrix[r-1][c+1]` if `c < n-1`, else `MAX_VALUE`
   - `matrix[r][c] += min(left, mid, right)`.
3. Return the minimum value in the last row.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Top-down Memo | O(n²) | O(n²) |
| Bottom-up In-place | O(n²) | O(1) |
