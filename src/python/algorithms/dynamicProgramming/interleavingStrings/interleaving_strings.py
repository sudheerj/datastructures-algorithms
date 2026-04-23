def is_interleave(s1, s2, s3):
    m, n = len(s1), len(s2)
    if m + n != len(s3):
        return False
    dp = [[False] * (n + 1) for _ in range(m + 1)]
    dp[m][n] = True
    for i in range(m, -1, -1):
        for j in range(n, -1, -1):
            if i == m and j == n:
                continue
            k = i + j
            from_s1 = i < m and s1[i] == s3[k] and dp[i + 1][j]
            from_s2 = j < n and s2[j] == s3[k] and dp[i][j + 1]
            dp[i][j] = from_s1 or from_s2
    return dp[0][0]

if __name__ == "__main__":
    print("Input: s1='aab', s2='axy', s3='aaxaby' -> Output:", is_interleave('aab', 'axy', 'aaxaby')) # True
    print("Input: s1='aab', s2='axy', s3='abaaxy' -> Output:", is_interleave('aab', 'axy', 'abaaxy')) # False
    print("Input: s1='', s2='', s3='' -> Output:", is_interleave('', '', '')) # True
    print("Input: s1='abc', s2='', s3='abc' -> Output:", is_interleave('abc', '', 'abc')) # True
    print("Input: s1='', s2='xyz', s3='xyz' -> Output:", is_interleave('', 'xyz', 'xyz')) # True
    print("Input: s1='abc', s2='def', s3='abcd' -> Output:", is_interleave('abc', 'def', 'abcd')) # False
    print("Input: s1='aa', s2='ab', s3='aaba' -> Output:", is_interleave('aa', 'ab', 'aaba')) # True
