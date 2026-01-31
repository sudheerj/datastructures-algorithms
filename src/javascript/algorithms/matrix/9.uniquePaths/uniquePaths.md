# **Unique Paths**

## **Problem Statement**
A robot is located at the top-left corner of an m x n grid. The robot can only move either down or right at any point. How many unique paths exist to reach the bottom-right corner?

---

## **Examples**

### Example 1:
- **Input**: `m = 3, n = 7`
- **Output**: `28`

### Example 2:
- **Input**: `m = 3, n = 2`
- **Output**: `3`

---

## **Algorithmic Approach**

### Dynamic Programming:
1. Create DP array where `dp[i][j]` = number of paths to reach cell (i, j).
2. First row and first column are all 1s (only one way to reach).
3. For each cell: `dp[i][j] = dp[i-1][j] + dp[i][j-1]`.
4. Return `dp[m-1][n-1]`.

### Mathematical (Combinations):
- Total moves needed: (m-1) down + (n-1) right = m+n-2.
- Answer = C(m+n-2, m-1) = choosing positions for down moves.

---

## **Time and Space Complexity**

**DP Approach:**
- **Time Complexity**: `O(m * n)`
- **Space Complexity**: `O(n)` optimized

**Mathematical:**
- **Time Complexity**: `O(min(m, n))`
- **Space Complexity**: `O(1)`
