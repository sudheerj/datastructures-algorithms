"""
Fibonacci Number (LeetCode 509)

Return the n-th Fibonacci number: F(0)=0, F(1)=1, F(n)=F(n-1)+F(n-2).

Approach 1: Recursion           TC: O(2^n)  SC: O(n)
Approach 2: Memoization         TC: O(n)    SC: O(n)
Approach 3: Tabulation          TC: O(n)    SC: O(n)
Approach 4: Space-Optimized     TC: O(n)    SC: O(1)
"""

from functools import lru_cache


# Approach 1: Recursion (Brute Force)
def fibonacci1(n):
    if n <= 1:
        return n
    return fibonacci1(n - 1) + fibonacci1(n - 2)


# Approach 2: Memoization (Top-down DP)
def fibonacci2(n, memo=None):
    if memo is None:
        memo = {}
    if n <= 1:
        return n
    if n in memo:
        return memo[n]
    memo[n] = fibonacci2(n - 1, memo) + fibonacci2(n - 2, memo)
    return memo[n]


# Approach 3: Tabulation (Bottom-up DP)
def fibonacci3(n):
    if n <= 1:
        return n
    dp = [0] * (n + 1)
    dp[1] = 1
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]
    return dp[n]


# Approach 4: Space-Optimized DP
def fibonacci4(n):
    if n <= 1:
        return n
    first, second = 0, 1
    for _ in range(2, n + 1):
        first, second = second, first + second
    return second


if __name__ == "__main__":
    test_cases = [
        (0,  0,  "n=0"),
        (1,  1,  "n=1"),
        (2,  1,  "n=2"),
        (3,  2,  "n=3"),
        (5,  5,  "n=5"),
        (10, 55, "n=10"),
    ]
    methods = [
        ("Recursion",       fibonacci1),
        ("Memoization",     fibonacci2),
        ("Tabulation",      fibonacci3),
        ("Space-Optimized", fibonacci4),
    ]

    for name, fn in methods:
        print(f"=== {name} ===")
        for n, expected, label in test_cases:
            result = fn(n)
            status = "PASS" if result == expected else "FAIL"
            print(f"  [{status}] {label}: {result}  (expected {expected})")
