"""
Minimum Substrings Without Repeating Characters

Given a string, find the minimum number of substrings such that
no substring contains repeating characters.

Time Complexity: O(n)
Space Complexity: O(k) where k is charset size
"""


def min_substrings_without_repeating_char(s):
    """
    Greedy approach using a set.
    TC: O(n), SC: O(k)
    """
    seen = set()
    count_substrings = 0

    for char in s:
        if char in seen:
            count_substrings += 1
            seen.clear()
        seen.add(char)

    return count_substrings + 1 if seen else count_substrings


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("abcabcbb", 4),
        ("bbbbb", 5),
        ("pwwkew", 3),
        ("", 0),
        ("a", 1),
        ("abacabadabacaba", 8),
    ]

    for s, expected in test_cases:
        result = min_substrings_without_repeating_char(s)
        print(f"Input: \"{s}\" | Output: {result} | Expected: {expected}")
