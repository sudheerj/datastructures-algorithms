# Edit Distance (Levenshtein Distance)
# TC: O(mn), SC: O(mn)

def edit_distance(w1: str, w2: str) -> int:
    m, n = len(w1), len(w2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    for i in range(n):
        dp[m][i] = n - i
    for j in range(m):
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
        ("horse", "ros", 3),
        ("intention", "execution", 5),
        ("", "abc", 3),
        ("abc", "", 3),
        ("abc", "abc", 0),
        ("kitten", "sitting", 3),
        ("flaw", "lawn", 2),
        ("a", "b", 1),
        ("", "", 0),
    ]
    for w1, w2, expected in test_cases:
        result = edit_distance(w1, w2)
        status = "✓" if result == expected else f"✗ (expected {expected})"
        print(f'"{w1}", "{w2}" => {result} {status}')
