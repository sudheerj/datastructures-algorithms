**Description:**
Given an `m x n` integer matrix, return the length of the longest strictly increasing path. From each cell, you may move up, down, left, or right. Diagonal moves are not allowed.

### Examples

Example 1:

Input: `matrix = [[9,9,4],[6,6,8],[2,1,1]]`
Output: `4`
Explanation: One longest increasing path is `1 -> 2 -> 6 -> 9`.

Example 2:

Input: `matrix = [[3,4,5],[3,2,6],[2,2,1]]`
Output: `4`
Explanation: One longest increasing path is `3 -> 4 -> 5 -> 6`.

Example 3:

Input: `matrix = [[1]]`
Output: `1`
Explanation: The only path consists of the single cell.

**Algorithmic Steps**
This solution uses depth-first search with memoization (top-down dynamic programming).

1. Create a memoization matrix `dp`, where `dp[r][c]` stores the longest increasing path starting at cell `(r, c)`.
2. Visit each cell and run DFS if its result has not already been computed.
3. For each cell, examine its four orthogonal neighbors. Continue only to neighbors with a strictly greater value.
4. The path length from a cell is one plus the maximum path length from any valid greater neighbor. If there are no valid neighbors, its path length is `1`.
5. Cache each computed path length and track the maximum across all starting cells.

**Time and Space complexity:**
The time complexity is `O(m * n)`, since each cell is computed once and checks at most four neighbors.

The space complexity is `O(m * n)` for the memoization matrix and the DFS recursion stack.

**Java Implementation:** [LongestIncreasingPathInMatrix.java](./LongestIncreasingPathInMatrix.java)
