"""
Edit Distance (LeetCode 72)

Given two strings w1 and w2, return the minimum number of operations
(insert, delete, replace) to convert w1 into w2.

Approach 1: Top-down Memoization  TC: O(m*n)  SC: O(m*n)
Approach 2: Bottom-up DP          TC: O(m*n)  SC: O(m*n)
"""


# Approach 1: Top-down Memoization
def edit_distance1(w1, w2):
    m, n = len(w1), len(w2)
    memo = {}

    def dfs(r, c):
        if r == m: return n - c
        if c == n: return m - r
        if (r, c) in memo: return memo[(r, c)]
        if w1[r] == w2[c]:
            memo[(r, c)] = dfs(r + 1, c + 1)
        else:
            memo[(r, c)] = 1 + min(dfs(r, c + 1), dfs(r + 1, c), dfs(r + 1, c + 1))
        return memo[(r, c)]

    return dfs(0, 0)


# Approach 2: Bottom-up DP
def edit_distance2(w1, w2):
    m, n = len(w1), len(w2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    for i in range(n + 1):
        dp[m][i] = n - i
    for j in range(m + 1):
        dp[j][n] = m - j
    for i in range(m - 1, -1, -1):
        for j in range(n - 1, -1, -1):
            if w1[i] == w2[j]:
                dp[i][j] = dp[i + 1][j + 1]
            else:
                dp[i][j] = 1 + min(dp[i][j + 1], dp[i + 1][j], dp[i + 1][j + 1])
    return dp[0][0]


if __name__ == "__main__":
    test_cases = [
        ("horse",     "ros",       3, "horse->ros"),
        ("intention", "execution", 5, "intention->execution"),
        ("",          "abc",       3, "empty->abc"),
        ("abc",       "",          3, "abc->empty"),
        ("abc",       "abc",       0, "abc->abc"),
        ("kitten",    "sitting",   3, "kitten->sitting"),
        ("flaw",      "lawn",      2, "flaw->lawn"),
        ("a",         "b",         1, "a->b"),
        ("",          "",          0, "empty->empty"),
    ]
    methods = [
        ("Top-down Memoization", edit_distance1),
        ("Bottom-up DP",         edit_distance2),
    ]

    for name, fn in methods:
        print(f"=== {name} ===")
        for w1, w2, expected, label in test_cases:
            result = fn(w1, w2)
            status = "PASS" if result == expected else "FAIL"
            print(f"  [{status}] {label}: {result}  (expected {expected})")
