"""
Two Characters

Given a string, find the length of the longest valid alternating string
formed by selecting exactly two distinct characters.

Time Complexity: O(n * k^2) where k is the number of unique characters
Space Complexity: O(n)
"""


def two_characters(s):
    """
    Try all pairs of unique characters, filter and check alternating.
    TC: O(n * k^2), SC: O(n)
    """
    unique_chars = list(set(s))
    max_length = 0

    for i in range(len(unique_chars)):
        for j in range(i + 1, len(unique_chars)):
            char1 = unique_chars[i]
            char2 = unique_chars[j]
            filtered = "".join(c for c in s if c == char1 or c == char2)

            if is_valid_alternating(filtered):
                max_length = max(max_length, len(filtered))

    return max_length


def is_valid_alternating(s):
    """
    Checks if a string has alternating characters with length > 1.
    """
    for i in range(1, len(s)):
        if s[i] == s[i - 1]:
            return False
    return len(s) > 1


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("beabeefeab", 5),
        ("asdcbsdcagfsdbgdfanfghbsfdab", 8),
        ("aaaa", 0),
        ("ababab", 6),
        ("abcabc", 4),
    ]

    for s, expected in test_cases:
        result = two_characters(s)
        print(f"Input: \"{s}\" | Output: {result} | Expected: {expected}")
