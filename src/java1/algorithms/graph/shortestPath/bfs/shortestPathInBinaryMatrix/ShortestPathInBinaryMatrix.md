**Description:**
Given an `n x n` binary matrix `grid`, return the length of the shortest clear path in the matrix. If there is no clear path, return `-1`.

A **clear path** in a binary matrix is a path from the **top-left** cell (i.e., `(0, 0)`) to the **bottom-right** cell (i.e., `(n - 1, n - 1)`) such that:
- All the visited cells of the path are `0`.
- All the adjacent cells of the path are **8-directionally** connected (i.e., they are different and they share an edge or a corner).

The **length of a clear path** is the number of visited cells in this path.

## Examples:

**Example 1:**
```
Input: grid = [[0,1],[1,0]]
Output: 2
Explanation: The shortest clear path is (0,0) -> (1,1)
```

**Example 2:**
```
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Explanation: The shortest clear path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2)
```

**Example 3:**
```
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
Explanation: The starting cell is blocked (has value 1), so no path exists.
```

**Example 4:**
```
Input: grid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 4
Explanation: The shortest path can go diagonally around the obstacle in the center.
```

**Example 5:**
```
Input: grid = [[0]]
Output: 1
Explanation: Single cell grid - already at the destination.
```

## Algorithmic Steps (BFS Approach)

This problem is solved efficiently using **Breadth-First Search (BFS)**, which is ideal for finding the shortest path in an unweighted graph. The key insight is that BFS explores nodes level by level, guaranteeing that the first time we reach the destination, we've found the shortest path.

1. **Initial Validation**:
   - Check if the starting cell `(0, 0)` or ending cell `(n-1, n-1)` is blocked (has value 1)
   - If either is blocked, return `-1` immediately as no path exists

2. **Initialize BFS**:
   - Create a queue and add the starting position `(0, 0)`
   - Mark the starting cell as visited by setting `grid[0][0] = 1`
   - Initialize step counter to 1 (counting the starting cell)

3. **BFS Traversal**:
   - While the queue is not empty:
     - Process all cells at the current level (distance from start)
     - For each cell in the current level:
       - If it's the destination `(n-1, n-1)`, return the current step count
       - Otherwise, explore all 8 adjacent directions (up, down, left, right, and 4 diagonals)
       - For each valid adjacent cell (within bounds and value is 0):
         - Add it to the queue
         - Mark it as visited by setting its value to 1
     - Increment the step counter after processing the entire level

4. **Return Result**:
   - If we exit the BFS loop without finding the destination, return `-1` (no path exists)

## Eight Directions Explained:

The algorithm explores 8 directions from each cell:
- **Cardinal directions**: Right (0,1), Left (0,-1), Down (1,0), Up (-1,0)
- **Diagonal directions**: Down-Right (1,1), Down-Left (1,-1), Up-Right (-1,1), Up-Left (-1,-1)

## Why BFS Works:

- **Level-by-level exploration**: BFS explores all cells at distance `k` before exploring cells at distance `k+1`
- **First arrival is shortest**: The first time BFS reaches a cell, it's guaranteed to be via the shortest path
- **Unweighted graph**: All edges (moves) have equal weight (1 step), making BFS optimal

## Time and Space Complexity:

**Time Complexity:** `O(n²)` where `n` is the dimension of the grid.
- In the worst case, we visit every cell in the `n × n` grid exactly once
- For each cell, we check up to 8 directions, which is a constant operation

**Space Complexity:** `O(n²)`
- The queue can hold up to `O(n²)` cells in the worst case (e.g., when most cells are traversable)
- We modify the input grid for marking visited cells (no extra space for visited set)

## Constraints:
- `n == grid.length`
- `n == grid[i].length`
- `1 ≤ n ≤ 100`
- `grid[i][j]` is `0` or `1`
