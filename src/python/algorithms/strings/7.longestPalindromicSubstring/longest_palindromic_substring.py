"""
Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

Time Complexity: O(n^2)
Space Complexity: O(1)
"""


def longest_palindrome(s):
    """
    Expand around center approach.
    TC: O(n^2), SC: O(1)
    """
    if not s:
        return ""
    
    def expand_around_center(left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left + 1:right]
    
    result = ""
    
    for i in range(len(s)):
        # Odd length palindromes
        odd = expand_around_center(i, i)
        if len(odd) > len(result):
            result = odd
        
        # Even length palindromes
        even = expand_around_center(i, i + 1)
        if len(even) > len(result):
            result = even
    
    return result


def longest_palindrome_dp(s):
    """
    Dynamic programming approach.
    TC: O(n^2), SC: O(n^2)
    """
    if not s:
        return ""
    
    n = len(s)
    dp = [[False] * n for _ in range(n)]
    start = 0
    max_len = 1
    
    # All single characters are palindromes
    for i in range(n):
        dp[i][i] = True
    
    # Check for palindromes of length 2
    for i in range(n - 1):
        if s[i] == s[i + 1]:
            dp[i][i + 1] = True
            start = i
            max_len = 2
    
    # Check for palindromes of length 3 or more
    for length in range(3, n + 1):
        for i in range(n - length + 1):
            j = i + length - 1
            if s[i] == s[j] and dp[i + 1][j - 1]:
                dp[i][j] = True
                start = i
                max_len = length
    
    return s[start:start + max_len]


# Test cases
if __name__ == "__main__":
    test_cases = [
        "babad",   # "bab" or "aba"
        "cbbd",    # "bb"
    ]
    
    for s in test_cases:
        print(f"String: '{s}'")
        print(f"Longest palindrome: '{longest_palindrome(s)}'")
        print()
