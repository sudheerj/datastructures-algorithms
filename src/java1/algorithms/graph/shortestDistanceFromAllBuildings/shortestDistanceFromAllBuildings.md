**Problem statement:** You are given an `m x n` grid where each cell is `0` (empty land), `1` (building), or `2` (obstacle). You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. Return the minimum total travel distance, or `-1` if it is not possible.

### Examples

```
Input: grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 7
Explanation: The best position is (1,2) with distances 3+3+1 = 7.

Input: grid = [[1,0]]
Output: 1

Input: grid = [[0,1,0],[0,0,0],[0,1,0]]
Output: 2
Explanation: Position (1,1) has distance 1+1 = 2 from both buildings.
```

**Algorithmic Steps**

1. Initialize a `distance` array of the same size as the grid (all zeros) and a `walk` counter starting at `0`.
2. For each building (`grid[row][col] == 1`), run a BFS:
   - Only visit empty cells where `grid[nr][nc] == walk` (ensures only cells reachable from all previous buildings are visited).
   - Decrement `grid[nr][nc]` to mark it as visited for this round.
   - Accumulate `distance[nr][nc] += level` (BFS distance).
   - Enqueue the neighbor.
   - After BFS, decrement `walk`.
3. After all BFS passes, scan the grid for cells where `grid[row][col] == walk` (reachable from every building) and return the minimum `distance[row][col]`.
4. Return `-1` if no such cell exists.

| Complexity | Value |
|---|---|
| Time | O(k × m × n) — k = number of buildings |
| Space | O(m × n) |
