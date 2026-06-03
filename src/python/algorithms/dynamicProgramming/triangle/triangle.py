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


# Approach 3: Space-optimized
def triangle3(t):
    n = len(t)
    dp = t[n - 1][:]  # copy last row

    for r in range(n - 2, -1, -1):
        for c in range(len(t[r])):
            dp[c] = t[r][c] + min(dp[c], dp[c + 1])

    return dp[0]


# Approach 4: In-place (operates on a copy to avoid mutating input)
def triangle4(t):
    tri = [row[:] for row in t]  # shallow copy per row
    n = len(tri)

    for r in range(n - 2, -1, -1):
        for c in range(len(tri[r])):
            tri[r][c] = tri[r][c] + min(tri[r + 1][c], tri[r + 1][c + 1])

    return tri[0][0]


if __name__ == "__main__":
    # Test cases: [triangle, expected]
    tests = [
        ([[2],[3,4],[6,5,7],[4,1,8,3]], 11),
        ([[-10]], -10),
        ([[1],[2,3]], 3),
        ([[-1],[2,3],[1,-1,-3]], -1),
        ([[1],[2,3],[4,5,6],[7,8,9,10]], 14),
        ([[-1],[-2,-3]], -4),
        ([[5],[-3,2],[1,4,-1],[-2,3,1,0]], 1),
        ([[1],[1,1],[1,1,1]], 3),
        ([[10],[9,8],[7,6,5]], 23),
        ([[-5],[-2,-4],[-1,-3,-6],[-8,-9,-10,-11]], -26)
    ]

    print("Triangle - Test Results:")
    print("=" * 120)

    passed = 0
    for i, (triangle, expected) in enumerate(tests, 1):
        # Test all four approaches
        result1 = triangle1(triangle)
        result2 = triangle2(triangle)
        result3 = triangle3(triangle)
        result4 = triangle4(triangle)

        test_pass = (result1 == expected and result2 == expected and 
                    result3 == expected and result4 == expected)

        # Debug: print all results if test fails
        if not test_pass:
            print(f"Test {i:2d} FAIL | Input: {triangle}")
            print(f"  Memoization: {result1}, DP: {result2}, Space-opt: {result3}, In-place: {result4} | Expected: {expected}")
        else:
            print(f"Test {i:2d} | Input: {str(triangle):50s} | Output: {result1} | Expected: {expected} | PASS")
            passed += 1

    print("=" * 120)
    print(f"Tests Passed: {passed}/{len(tests)}")
