**Problem statement:**

You are given an `m x n` matrix `heights`, where `heights[row][col]` represents the height of a cell. You may move up, down, left, or right. The effort of a path is the maximum absolute height difference between two consecutive cells on that path. Return the minimum effort required to travel from the top-left cell `(0, 0)` to the bottom-right cell `(m - 1, n - 1)`.

## Examples

**Example 1:**

```text
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: One path is 1 -> 3 -> 5 -> 3 -> 5, whose largest consecutive height difference is 2.
```

**Example 2:**

```text
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: A path around the cell with height 8 has maximum consecutive height difference 1.
```

**Example 3:**

```text
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: A path exists using only cells of height 1, so every step has height difference 0.
```

## Algorithmic steps (Dijkstra with a min-heap)

1. Let `dist[row][col]` store the smallest path effort found so far to reach that cell. Initialize all entries to infinity, except `dist[0][0] = 0`.
2. Add the starting state `{effort = 0, row = 0, col = 0}` to a min-heap ordered by effort.
3. While the heap is not empty, remove the state with the smallest effort.
4. If the removed cell is the destination, return its effort.
5. For each of its four valid neighbors:
   - Compute the edge effort as the absolute difference between the two cell heights.
   - Compute the path effort to the neighbor as the maximum of the current path effort and this edge effort.
   - If this value is smaller than the neighbor's recorded `dist`, update `dist` and add the neighbor to the heap.
6. Return `0` if the heap empties without reaching the destination. With a rectangular grid, the destination is always reachable, so the implementation's final fallback is not normally needed.

## Key insight

This is a minimax path problem, not a shortest-sum path problem. Extending a route uses `max(currentPathEffort, nextEdgeDifference)` rather than adding edge weights. The min-heap processes the currently lowest-effort candidate first, so the destination's effort is optimal when it is removed from the heap.

## Complexity

Let `R` be the number of rows and `C` the number of columns.

- **Time:** `O(R * C * log(R * C))`. Each cell is inserted into the priority queue when its best effort improves, and each cell has at most four neighbors.
- **Space:** `O(R * C)` for the distance matrix and priority queue.

## Constraints

- `1 <= rows, columns <= 100`
- `1 <= heights.length <= 100`
- `1 <= heights[i].length <= 100`
- `1 <= heights[i][j] <= 10^6`
