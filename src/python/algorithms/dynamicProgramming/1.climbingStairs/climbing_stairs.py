"""
Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps.
In how many distinct ways can you climb to the top?

Time Complexity: O(n)
Space Complexity: O(1)
"""


def climb_stairs(n):
    """
    Dynamic programming with space optimization.
    TC: O(n), SC: O(1)
    """
    if n <= 2:
        return n
    
    prev2, prev1 = 1, 2
    
    for _ in range(3, n + 1):
        current = prev1 + prev2
        prev2 = prev1
        prev1 = current
    
    return prev1


def climb_stairs_dp(n):
    """
    Dynamic programming with array.
    TC: O(n), SC: O(n)
    """
    if n <= 2:
        return n
    
    dp = [0] * (n + 1)
    dp[1] = 1
    dp[2] = 2
    
    for i in range(3, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]
    
    return dp[n]


# Test cases
if __name__ == "__main__":
    test_cases = [2, 3, 5, 10]
    
    for n in test_cases:
        print(f"n = {n}")
        print(f"Ways to climb: {climb_stairs(n)}")
        print()
