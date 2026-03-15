def climbing_stairs1(n):
    if n < 2:
        return n

    dp = [0] * (n+1)
    dp[1] = 1
    dp[2] = 2

    for i in range(3, n+1):
        dp[i] = dp[i-1] + dp[i-2];

    return dp[n]

def climbing_stairs2(n):

    if n < 2:
        return n

    prev2, prev1 = 1, 2

    for _ in range(3, n+1):
        current = prev2 + prev1
        prev2 = prev1
        prev1 = current

    return prev1

# Test cases
if __name__ == "__main__":
    test_cases = [2, 3, 5, 10]
    
    for n in test_cases:
        print(f"n = {n}")
        print(f"Ways to climb: {climbing_stairs1(n)}")
        print(f"Ways to climb: {climbing_stairs2(n)}")
        print()