"""
Palindromic Substrings

Given a string str, return the number of substrings within str that are palindromes.

Time Complexity: O(n^2)
Space Complexity: O(1)
"""


def count_palindromic_substrings(s):
    """
    Expand around center approach.
    TC: O(n^2), SC: O(1)
    """
    if not s:
        return 0

    count = 0
    for i in range(len(s)):
        count += expand_around_center(s, i, i)       # Odd length palindromes
        count += expand_around_center(s, i, i + 1)   # Even length palindromes
    return count


def expand_around_center(s, left, right):
    """
    Expands around the given center and counts palindromic substrings.
    """
    count = 0
    while left >= 0 and right < len(s) and s[left] == s[right]:
        count += 1
        left -= 1
        right += 1
    return count


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("baaab", 9),
        ("abcd", 4),
        ("aaa", 6),
        ("", 0),
        ("a", 1),
        ("abccba", 9),
    ]

    for s, expected in test_cases:
        result = count_palindromic_substrings(s)
        print(f"Input: \"{s}\" | Output: {result} | Expected: {expected}")
