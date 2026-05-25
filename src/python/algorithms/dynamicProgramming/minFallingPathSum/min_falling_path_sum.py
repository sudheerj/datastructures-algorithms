"""
Minimum Falling Path Sum (LeetCode 931)

Given an n x n matrix, find the minimum sum of a falling path.
From (r, c) you can move to (r+1, c-1), (r+1, c), or (r+1, c+1).

Approach 1: Top-down Memoization  TC: O(n^2)  SC: O(n^2)
Approach 2: Bottom-up In-place    TC: O(n^2)  SC: O(1)
"""

import math


# Approach 1: Top-down Memoization
def min_falling_path_sum1(matrix):
    n = len(matrix)
    memo = {}

    def dfs(r, c):
        if r == n: return 0
        if c < 0 or c >= n: return math.inf
        if (r, c) in memo: return memo[(r, c)]
        memo[(r, c)] = matrix[r][c] + min(dfs(r + 1, c - 1), dfs(r + 1, c), dfs(r + 1, c + 1))
        return memo[(r, c)]

    return min(dfs(0, c) for c in range(n))


# Approach 2: Bottom-up In-place (operates on a copy)
def min_falling_path_sum2(matrix):
    m = [row[:] for row in matrix]
    n = len(m)

    for r in range(1, n):
        for c in range(n):
            left  = m[r - 1][c - 1] if c > 0     else math.inf
            mid   = m[r - 1][c]
            right = m[r - 1][c + 1] if c < n - 1 else math.inf
            m[r][c] += min(left, mid, right)

    return min(m[n - 1])


if __name__ == "__main__":
    test_cases = [
        ([[2,1,3],[6,5,4],[7,8,9]],   13,  "3x3 standard"),
        ([[-19,57],[-40,-5]],         -59, "2x2 negative"),
        ([[1]],                        1,  "single cell"),
        ([[1,2,3],[4,5,6],[7,8,9]],   12,  "3x3 ascending"),
        ([[-1,-2],[-3,-4]],           -6,  "2x2 all negative"),
    ]
    methods = [
        ("Top-down Memoization", min_falling_path_sum1),
        ("Bottom-up In-place",   min_falling_path_sum2),
    ]

    for name, fn in methods:
        print(f"=== {name} ===")
        for matrix, expected, label in test_cases:
            result = fn(matrix)
            status = "PASS" if result == expected else "FAIL"
            print(f"  [{status}] {label}: {result}  (expected {expected})")
