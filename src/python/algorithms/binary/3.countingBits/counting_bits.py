"""
Counting Bits

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def count_bits(n):
    """
    Dynamic programming approach.
    TC: O(n), SC: O(n)
    """
    dp = [0] * (n + 1)
    offset = 1
    
    for i in range(1, n + 1):
        if offset * 2 == i:
            offset = i
        dp[i] = 1 + dp[i - offset]
    
    return dp


def count_bits_alternative(n):
    """
    Using bit manipulation.
    TC: O(n), SC: O(n)
    """
    dp = [0] * (n + 1)
    
    for i in range(1, n + 1):
        # dp[i] = dp[i >> 1] + (i & 1)
        dp[i] = dp[i // 2] + (i % 2)
    
    return dp


# Test cases
if __name__ == "__main__":
    test_cases = [2, 5, 8]
    
    for n in test_cases:
        print(f"n = {n}")
        print(f"Counting bits: {count_bits(n)}")
        print()
