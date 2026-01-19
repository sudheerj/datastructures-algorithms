"""
Unique Paths

A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time.
How many possible unique paths are there to reach the bottom-right corner?

Time Complexity: O(m * n)
Space Complexity: O(n)
"""


def unique_paths(m, n):
    """
    Dynamic programming with space optimization.
    TC: O(m * n), SC: O(n)
    """
    row = [1] * n
    
    for _ in range(1, m):
        for j in range(1, n):
            row[j] += row[j - 1]
    
    return row[n - 1]


def unique_paths_math(m, n):
    """
    Using combinatorics: C(m+n-2, m-1)
    TC: O(min(m, n)), SC: O(1)
    """
    from math import factorial
    return factorial(m + n - 2) // (factorial(m - 1) * factorial(n - 1))


# Test cases
if __name__ == "__main__":
    test_cases = [
        (3, 7),  # 28
        (3, 2),  # 3
        (7, 3),  # 28
    ]
    
    for m, n in test_cases:
        print(f"Grid: {m}x{n}")
        print(f"Unique paths (DP): {unique_paths(m, n)}")
        print(f"Unique paths (Math): {unique_paths_math(m, n)}")
        print()
