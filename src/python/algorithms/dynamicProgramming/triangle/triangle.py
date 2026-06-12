"""
Triangle (LeetCode 120)

Given a triangle array, find the minimum path sum from top to bottom.
From index i, you can move to i or i+1 in the next row.

Approach 1: Top-down Memoization  TC: O(n^2)  SC: O(n^2)
Approach 2: Bottom-up DP          TC: O(n^2)  SC: O(n^2)
Approach 3: In-place              TC: O(n^2)  SC: O(1)
"""

import math


# Approach 1: Top-down Memoization
def triangle1(t):
    n = len(t)
    memo = {}

    def dfs(r, c):
        if r >= n:
            return 0
        if (r, c) in memo:
            return memo[(r, c)]
        memo[(r, c)] = t[r][c] + min(dfs(r + 1, c), dfs(r + 1, c + 1))
        return memo[(r, c)]

    return dfs(0, 0)


# Approach 2: Bottom-up DP
def triangle2(t):
    n = len(t)
    dp = [[0] * n for _ in range(n)]
    for c in range(len(t[n - 1])):
        dp[n - 1][c] = t[n - 1][c]

    for r in range(n - 2, -1, -1):
        for c in range(len(t[r])):
            dp[r][c] = t[r][c] + min(dp[r + 1][c], dp[r + 1][c + 1])

    return dp[0][0]


# Approach 3: In-place (operates on a copy to avoid mutating input)
def triangle3(t):
    tri = [row[:] for row in t]  # shallow copy per row
    n = len(tri)

    for r in range(n - 2, -1, -1):
        for c in range(len(tri[r])):
            tri[r][c] = tri[r][c] + min(tri[r + 1][c], tri[r + 1][c + 1])

    return tri[0][0]


if __name__ == "__main__":
    test_cases = [
        ([[2],[3,4],[6,5,7],[4,1,8,3]], 11, "standard 4-row"),
        ([[-10]],                        -10, "single negative"),
        ([[1],[2,3]],                    3,  "2-row"),
        ([[-1],[2,3],[1,-1,-3]],         -1, "negative values"),
        ([[1],[2,3],[4,5,6],[7,8,9,10]], 14, "4-row ascending"),
    ]
    methods = [
        ("Top-down Memoization", triangle1),
        ("Bottom-up DP",         triangle2),
        ("In-place",             triangle3),
    ]

    for name, fn in methods:
        print(f"=== {name} ===")
        for tri, expected, label in test_cases:
            result = fn(tri)
            status = "PASS" if result == expected else "FAIL"
            print(f"  [{status}] {label}: {result}  (expected {expected})")
