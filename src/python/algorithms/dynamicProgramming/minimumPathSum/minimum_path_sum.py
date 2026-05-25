"""
Minimum Path Sum (LeetCode 64)

Find the path from top-left to bottom-right (only right/down moves)
with the minimum sum.

Approach 1: Top-down Memoization  TC: O(m*n)  SC: O(m*n)
Approach 2: Bottom-up DP          TC: O(m*n)  SC: O(m*n)
Approach 3: Space-Optimized DP    TC: O(m*n)  SC: O(n)
"""

import math


# Approach 1: Top-down Memoization
def min_path_sum1(grid):
    rows, cols = len(grid), len(grid[0])
    memo = {}

    def dfs(r, c):
        if r >= rows or c >= cols:
            return math.inf
        if r == rows - 1 and c == cols - 1:
            return grid[r][c]
        if (r, c) in memo:
            return memo[(r, c)]
        memo[(r, c)] = grid[r][c] + min(dfs(r + 1, c), dfs(r, c + 1))
        return memo[(r, c)]

    return dfs(0, 0)


# Approach 2: Bottom-up DP
def min_path_sum2(grid):
    rows, cols = len(grid), len(grid[0])
    dp = [[math.inf] * (cols + 1) for _ in range(rows + 1)]
    dp[rows - 1][cols] = 0

    for r in range(rows - 1, -1, -1):
        for c in range(cols - 1, -1, -1):
            dp[r][c] = grid[r][c] + min(dp[r + 1][c], dp[r][c + 1])

    return dp[0][0]


# Approach 3: Space-Optimized DP
def min_path_sum3(grid):
    rows, cols = len(grid), len(grid[0])
    dp = [math.inf] * (cols + 1)
    dp[cols - 1] = 0

    for r in range(rows - 1, -1, -1):
        for c in range(cols - 1, -1, -1):
            dp[c] = grid[r][c] + min(dp[c], dp[c + 1])

    return dp[0]


if __name__ == "__main__":
    test_cases = [
        ([[1,3,1],[1,5,1],[4,2,1]], 7,  "3x3 standard"),
        ([[1,2,3],[4,5,6]],         12, "2x3 grid"),
        ([[1]],                     1,  "single cell"),
        ([[1,2],[1,1]],             3,  "2x2 grid"),
        ([[5,1,2],[3,6,4],[1,8,1]], 13, "3x3 off-diagonal min"),
    ]
    methods = [
        ("Top-down Memoization", min_path_sum1),
        ("Bottom-up DP",         min_path_sum2),
        ("Space-Optimized DP",   min_path_sum3),
    ]

    for name, fn in methods:
        print(f"=== {name} ===")
        for grid, expected, label in test_cases:
            result = fn(grid)
            status = "PASS" if result == expected else "FAIL"
            print(f"  [{status}] {label}: {result}  (expected {expected})")
