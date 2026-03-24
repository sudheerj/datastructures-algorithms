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
    
    first, second = 1, 1
    
    for _ in range(n-1):
        first, second = second, first+second
    
    return second


def climb_stairs_dp(n):
    """
    Dynamic programming with array.
    TC: O(n), SC: O(n)
    """
    if n <= 2:
        return n
    
    dp = [0] * (n + 1)
    dp[0] = 1
    dp[1] = 1
    
    for i in range(2, n+1):
        dp[i] = dp[i - 1] + dp[i - 2]
    
    return dp[n]

def climb_stairs_recursive(n):
    memo = {}
    def helper(k):
        if k <= 2:
            return k
        if k in memo:
            return memo[k]
        memo[k] = helper(k-1) + helper(k-2)
        return memo[k]

    return helper(n)


# Test cases
if __name__ == "__main__":
    test_cases = [2, 3, 5, 10]
    
    for n in test_cases:
        print(f"n = {n}")
        print(f"Ways to climb: {climb_stairs(n)}")
        print(f"Ways to climb: {climb_stairs_dp(n)}")
        print(f"Ways to climb: {climb_stairs_recursive(n)}")

        print()
