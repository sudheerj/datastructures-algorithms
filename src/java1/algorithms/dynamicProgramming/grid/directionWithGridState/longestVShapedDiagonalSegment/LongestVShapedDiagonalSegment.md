# Longest V-Shaped Diagonal Segment

## Problem statement

Given an `m x n` grid containing `0`, `1`, and `2`, find the longest diagonal segment that:

- Starts at a cell containing `1` and follows the repeating pattern `1 -> 2 -> 0 -> 2 -> 0 ...`.
- Moves diagonally in one of the four diagonal directions.
- May make at most one clockwise 90-degree turn while continuing the pattern.

The segment may end at any cell; it does not need to reach a grid boundary.

## Examples

### Example 1

Input:

```text
grid = [[2,2,1,2,2],
        [2,0,2,2,0],
        [2,0,1,1,0],
        [1,0,2,2,2],
        [2,0,0,2,2]]
```

Output: `5`

### Example 2

Input:

```text
grid = [[2,2,2,2,2],
        [2,0,2,2,0],
        [2,0,1,1,0],
        [1,0,2,2,2],
        [2,0,0,2,2]]
```

Output: `4`

### Example 3

Input:

```text
grid = [[1,2,2,2,2],
        [2,2,2,2,0],
        [2,0,0,0,0],
        [0,0,2,2,2],
        [2,0,0,2,0]]
```

Output: `5`

### Example 4

Input: `grid = [[1]]`

Output: `1`

## Algorithm: DFS with memoization

1. Try every cell containing `1` as a starting point and each of the four diagonal directions.
2. Memoize the best continuation for each state `(row, column, direction, canTurn)`.
3. From each cell, continue to the next diagonal cell only if it is in bounds and has the expected pattern value: `1` is followed by `2`, `2` by `0`, and `0` by `2`.
4. If the turn is still available, also try moving clockwise from the current cell and mark the turn as used.
5. Return the largest segment length found, counting the starting cell.

**Time complexity:** `O(m * n)`, since each cell has at most eight memoized direction/turn states.

**Space complexity:** `O(m * n)` for memoization and the recursion stack.

## Java implementation

[LongestVShapedDiagonalSegment.java](./LongestVShapedDiagonalSegment.java)