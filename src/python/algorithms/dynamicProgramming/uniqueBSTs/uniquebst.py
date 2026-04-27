def num_trees(n):
    dp = [0] * (n + 1)
    dp[0] = dp[1] = 1
    for nodes in range(2, n + 1):
        for root in range(1, nodes + 1):
            left = root - 1
            right = nodes - root
            dp[nodes] += dp[left] * dp[right]
    return dp[n]

if __name__ == "__main__":
    test_cases = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    for i, n in enumerate(test_cases, 1):
        print(f"Test case {i}: n = {n}")
        print("Output:", num_trees(n))
