"""
Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; 
in other words, it is the product of some integer with itself.
For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Time Complexity: O(n * sqrt(n))
Space Complexity: O(n)
"""


def num_squares(n):
    """
    Bottom-up DP approach (similar to coin change).
    TC: O(n * sqrt(n)), SC: O(n)
    
    Args:
        n: Target integer to represent as sum of perfect squares
        
    Returns:
        Minimum number of perfect squares that sum to n
    """
    # Initialize DP array with worst case (all 1s)
    dp = [n] * (n + 1)
    dp[0] = 0
    
    # For each target from 1 to n
    for target in range(1, n + 1):
        # Try all perfect squares up to target
        s = 1
        while s * s <= target:
            # Update minimum: current vs (1 + remaining)
            dp[target] = min(dp[target], 1 + dp[target - s * s])
            s += 1
    
    return dp[n]


if __name__ == "__main__":
    tests = [
        (12, 3),     # 12 = 4 + 4 + 4 (3 squares)
        (13, 2),     # 13 = 4 + 9 (2 squares)
        (1, 1),      # 1 = 1 (1 square)
        (2, 2),      # 2 = 1 + 1 (2 squares)
        (3, 3),      # 3 = 1 + 1 + 1 (3 squares)
        (4, 1),      # 4 = 4 (1 square)
        (7, 4),      # 7 = 4 + 1 + 1 + 1 (4 squares)
        (10, 2),     # 10 = 9 + 1 (2 squares)
        (25, 1),     # 25 = 25 (1 square)
        (26, 2),     # 26 = 25 + 1 (2 squares)
    ]
    
    print("Perfect Squares - Test Results:")
    print("=" * 50)
    
    passed = 0
    for i, (n, expected) in enumerate(tests, 1):
        result = num_squares(n)
        pass_test = result == expected
        
        if pass_test:
            passed += 1
        
        status = "PASS" if pass_test else "FAIL"
        print(f"Test {i:2d} | Input: {n:2d} | Output: {result} | Expected: {expected} | {status}")
    
    print("=" * 50)
    print(f"Tests Passed: {passed}/{len(tests)}")
