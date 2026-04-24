## N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other. Return all distinct solutions to the n-queens puzzle.

### Examples

**Example 1**
Input: n = 1
Output: [["Q"]]

**Example 2**
Input: n = 2
Output: []

**Example 3**
Input: n = 3
Output: []

**Example 4**
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."], ["..Q.","Q...","...Q",".Q.."]]

**Example 5**
Input: n = 5
Output: 10 solutions (not shown for brevity)

### Approach
- Use backtracking to try placing queens row by row.
- Track columns and diagonals to avoid conflicts.
- Time Complexity: O(n!)
- Space Complexity: O(n^2)
