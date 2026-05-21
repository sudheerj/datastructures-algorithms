**Problem statement:**
You are given an `m x n` grid where each cell contains a non-negative integer representing the amount of gold. You can start collecting gold from any non-zero cell and stop at any cell. Each step, you can move to an adjacent cell (up, down, left, right). You **cannot visit a cell with 0 gold** and **cannot revisit a cell** in the same path. Return the **maximum amount of gold** you can collect.

## Examples:
Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
(Path: 9→8→7, gold = 9+8+7 = 24)

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
(Path collecting from the connected region 3→4→5→6→7 and 3, total = 28)

**Algorithmic Steps**
This problem is solved using **DFS + Backtracking** to explore all possible paths from every non-zero starting cell. The algorithmic approach can be summarized as follows:

1. Create the main function `path_with_max_gold(grid)`. Use a list `max_gold = [0]` for mutation inside the closure.

2. Define an inner `dfs(r, c, current_gold)` function.

3. In the `dfs` function:
   1. **Base case:** if out of bounds or `grid[r][c] == 0`, return immediately.
   2. Read `gold = grid[r][c]`, add to `current_gold`.
   3. Update `max_gold[0] = max(max_gold[0], current_gold)`.
   4. **Mark as visited:** set `grid[r][c] = 0`.
   5. Recursively call `dfs` in all 4 directions.
   6. **Backtrack:** restore `grid[r][c] = gold`.

4. Iterate over every cell `(r, c)`. If `grid[r][c] != 0`, call `dfs(r, c, 0)`.

5. Return `max_gold[0]`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(m * n * 3^(m*n))` in the worst case — we start DFS from each non-zero cell, and at each step we can move in at most 3 new directions (we came from one). In practice it is much faster due to zero cells blocking paths.

The space complexity is `O(m * n)` for the recursion stack in the worst case (entire grid is non-zero).
