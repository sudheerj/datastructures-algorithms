def is_match(s, p):
    """Top-down memoization"""
    m, n = len(s), len(p)
    memo = {}

    def dfs(i, j):
        if (i, j) in memo:
            return memo[(i, j)]
        if j == n:
            memo[(i, j)] = (i == m)
            return memo[(i, j)]

        match = i < m and (p[j] == s[i] or p[j] == '.')

        if j + 1 < n and p[j + 1] == '*':
            result = dfs(i, j + 2) or (match and dfs(i + 1, j))
        else:
            result = match and dfs(i + 1, j + 1)

        memo[(i, j)] = result
        return result

    return dfs(0, 0)


def is_match1(s, p):
    """Bottom-up DP"""
    m, n = len(s), len(p)
    dp = [[False] * (n + 1) for _ in range(m + 1)]
    dp[m][n] = True

    for i in range(m, -1, -1):
        for j in range(n - 1, -1, -1):
            match = i < m and (p[j] == s[i] or p[j] == '.')
            if j + 1 < n and p[j + 1] == '*':
                dp[i][j] = dp[i][j + 2] or (match and dp[i + 1][j])
            else:
                dp[i][j] = match and dp[i + 1][j + 1]

    return dp[0][0]


if __name__ == "__main__":
    tests = [
        ("aa",  "a",     False),
        ("aa",  "a*",    True),
        ("ab",  ".*",    True),
        ("aab", "c*a*b", True),
        ("a",   ".",     True),
    ]

    for i, (s, p, expected) in enumerate(tests, 1):
        r1 = is_match(s, p)
        r2 = is_match1(s, p)
        print(f"{'PASS' if r1 == expected else 'FAIL'} test {i} is_match:  result={r1} expected={expected}")
        print(f"{'PASS' if r2 == expected else 'FAIL'} test {i} is_match1: result={r2} expected={expected}")
