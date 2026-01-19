"""
Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence.

Time Complexity: O(m * n)
Space Complexity: O(m * n) or O(min(m, n)) with space optimization
"""


def longest_common_subsequence(text1, text2):
    """
    Dynamic programming approach.
    TC: O(m * n), SC: O(m * n)
    """
    m, n = len(text1), len(text2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if text1[i - 1] == text2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    
    return dp[m][n]


def lcs_space_optimized(text1, text2):
    """
    Space optimized version.
    TC: O(m * n), SC: O(min(m, n))
    """
    if len(text1) < len(text2):
        text1, text2 = text2, text1
    
    n = len(text2)
    prev = [0] * (n + 1)
    curr = [0] * (n + 1)
    
    for i in range(1, len(text1) + 1):
        for j in range(1, n + 1):
            if text1[i - 1] == text2[j - 1]:
                curr[j] = prev[j - 1] + 1
            else:
                curr[j] = max(prev[j], curr[j - 1])
        prev, curr = curr, prev
    
    return prev[n]


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"text1": "abcde", "text2": "ace"},   # 3 ("ace")
        {"text1": "abc", "text2": "abc"},     # 3
        {"text1": "abc", "text2": "def"},     # 0
    ]
    
    for test in test_cases:
        print(f"text1: '{test['text1']}', text2: '{test['text2']}'")
        print(f"LCS length: {longest_common_subsequence(test['text1'], test['text2'])}")
        print()
