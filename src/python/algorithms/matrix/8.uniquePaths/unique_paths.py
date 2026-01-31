"""
Unique Paths

A robot is located at the top-left corner of an m x n grid. The robot can only 
move either down or right at any point. How many unique paths exist to reach 
the bottom-right corner?

Time Complexity: O(m * n)
Space Complexity: O(n) optimized, O(m * n) basic
"""


def unique_paths(m, n):
    """
    DP approach with space optimization.
    TC: O(m * n), SC: O(n)
    """
    # Each cell in current row only depends on cell above and cell to the left
    dp = [1] * n  # First row is all 1s
    
    for i in range(1, m):
        for j in range(1, n):
            dp[j] = dp[j] + dp[j - 1]  # paths from above + paths from left
    
    return dp[n - 1]


def unique_paths_2d_dp(m, n):
    """
    DP approach with 2D array.
    TC: O(m * n), SC: O(m * n)
    """
    dp = [[1] * n for _ in range(m)]
    
    for i in range(1, m):
        for j in range(1, n):
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    
    return dp[m - 1][n - 1]


def unique_paths_math(m, n):
    """
    Mathematical approach using combinations.
    Total moves = (m-1) down + (n-1) right = m+n-2 moves
    Choose (m-1) positions for down moves = C(m+n-2, m-1)
    TC: O(min(m, n)), SC: O(1)
    """
    from math import comb
    return comb(m + n - 2, m - 1)


# Test cases
if __name__ == "__main__":
    # Example 1
    print(f"Unique paths(3, 7): {unique_paths(3, 7)}")  # 28
    
    # Example 2
    print(f"Unique paths(3, 2): {unique_paths(3, 2)}")  # 3
    
    # Example 3
    print(f"Unique paths(7, 3): {unique_paths(7, 3)}")  # 28
    
    # Example 4
    print(f"Unique paths(3, 3): {unique_paths(3, 3)}")  # 6
    
    # Using math approach
    print(f"Unique paths (math)(3, 7): {unique_paths_math(3, 7)}")  # 28
