**Problem statement:**
You are given an empty `m x n` 2D binary grid. Initially, all cells are water (`0`). You are given a list of `positions` where `positions[i] = [ri, ci]` represents a cell to turn into land (`1`). After each position is turned into land, return a list of integers representing the **number of islands** at that point.

An island is a group of `1`s connected horizontally or vertically, surrounded by water.

## Examples:
Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
Output: [1, 1, 2, 3]

Input: m = 2, n = 2, positions = [[0,0],[0,1],[1,0],[1,1]]
Output: [1, 1, 1, 1]

**Algorithmic Steps**
This problem is solved using a **Union-Find (Disjoint Set Union)** data structure to efficiently track and merge connected land components after each position is added. The algorithmic approach can be summarized as follows:

1. Create a `UnionFind` class with:
   - `parent[]` array initialized to `-1` for all cells (water).
   - `rank[]` array for union-by-rank optimization.
   - `addLand(x)` — sets `parent[x] = x` to mark cell as land.
   - `isLand(x)` — returns `parent[x] != -1`.
   - `find(x)` — returns the root of `x` using path compression.
   - `union(x, y)` — merges two components by rank; returns `true` if merged.

2. Create the main function `numberOfIslands(m, n, positions)`.

3. Convert 2D coordinates `(row, col)` to a 1D index using `row * n + col`.

4. For each position `(row, col)` in `positions`:
   1. Compute the 1D `index`. If `isLand(index)` is already true, append current count and `continue`.
   2. Call `addLand(index)` and increment `islandsCount`.
   3. Check all 4 neighbors. For each in-bounds land neighbor, call `union(index, neighbourIndex)`. If it returns `true`, decrement `islandsCount`.
   4. Append `islandsCount` to the result list.

5. Return the result list.

**Time and Space complexity:**
This algorithm has a time complexity of `O(k * α(m*n))` ≈ `O(k)`, where `k` is the number of positions and `α` is the inverse Ackermann function (effectively constant) due to path compression and union by rank.

The space complexity is `O(m * n)` for the `parent` and `rank` arrays in the `UnionFind` structure.
