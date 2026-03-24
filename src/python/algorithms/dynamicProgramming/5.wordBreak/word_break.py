"""
Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented
into a space-separated sequence of one or more dictionary words.

Time Complexity: O(n^2 * m) where n is string length, m is average word length
Space Complexity: O(n)
"""


def word_break(s, word_dict):
    """
    Dynamic programming approach.
    TC: O(n^2 * m), SC: O(n)
    """
    dp = [False] * (n+1)
    dp[n] = True # Empty string

    for i in range(n-1, -1, -1):
        for w in word_set:
            end = i + len(w)

            if end <= n and s[i:end] == w:
                dp[i] = dp[i+len(w)]
                if dp[i]:
                    break

    return dp[0]


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"s": "leetcode", "wordDict": ["leet", "code"]},      # True
        {"s": "applepenapple", "wordDict": ["apple", "pen"]}, # True
        {"s": "catsandog", "wordDict": ["cats", "dog", "sand", "and", "cat"]},  # False
    ]
    
    for test in test_cases:
        print(f"s: '{test['s']}', wordDict: {test['wordDict']}")
        print(f"Can break: {word_break(test['s'], test['wordDict'])}")
        print()
