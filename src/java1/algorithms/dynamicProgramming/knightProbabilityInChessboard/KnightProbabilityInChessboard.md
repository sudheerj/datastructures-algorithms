# Knight Probability in Chessboard

## Problem Description

On an `n x n` chessboard, a knight starts at the cell `(row, column)` and attempts to make exactly `k` moves. The rows and columns are 0-indexed, so the top-left cell is `(0, 0)`, and the bottom-right cell is `(n - 1, n - 1)`.

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.

Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly `k` moves or has moved off the chessboard.

Return the **probability** that the knight remains on the board after it has stopped moving.

### Example 1:
```
Input: n = 3, k = 2, row = 0, column = 0
Output: 0.06250
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
```

### Example 2:
```
Input: n = 1, k = 0, row = 0, column = 0
Output: 1.00000
Explanation: No moves are made, so the knight stays on the board with probability 1.
```

### Example 3:
```
Input: n = 8, k = 30, row = 6, column = 4
Output: 0.00019
Explanation: After 30 moves, the probability is very low but non-zero.
```

## Constraints
- `1 <= n <= 25`
- `0 <= k <= 100`
- `0 <= row, column < n`

## Approach

### Approach 1: Top-Down Memoization
1. Use DFS with memoization to explore all possible knight moves
2. At each position, calculate probability as sum of all 8 directions
3. Base case: if knight is off board, return 0; if k=0, return 1
4. Each move has probability 1/8, multiply by recursive result
5. Memoize results in 3D array: `memo[row][column][moves]`

**Knight Moves Pattern:**
```
  (r-2,c-1) (r-2,c+1)
(r-1,c-2)       (r-1,c+2)
      KNIGHT
(r+1,c-2)       (r+1,c+2)
  (r+2,c-1) (r+2,c+1)
```

### Approach 2: Bottom-Up DP with Space Optimization
1. Initialize board with probability 1.0 at starting position
2. For each of k moves, create new probability board
3. For each cell with non-zero probability:
   - Distribute probability to all 8 knight destinations (each gets 1/8)
4. Sum all probabilities on final board for total remaining probability
5. Use two boards alternating (current and next) for space optimization

**Time and Space complexity:**

| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Top-Down Memoization | O(n² × k) | O(n² × k) |
| Bottom-Up DP | O(n² × k) | O(n²) |

The **Bottom-Up DP approach** is optimal with O(n² × k) time and O(n²) space, using only two boards.

## Key Insights

1. **Probability Distribution**: Each knight move has equal probability (1/8)
2. **Boundary Conditions**: Moves off the board contribute 0 to probability
3. **State Independence**: After k moves, probability only depends on current position and remaining moves
4. **Space Optimization**: Only need current and next state for bottom-up approach
5. **Floating Point**: Use double precision for accurate probability calculations
