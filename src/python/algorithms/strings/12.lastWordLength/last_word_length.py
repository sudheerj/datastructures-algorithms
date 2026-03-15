"""
Length of Last Word

Given an input string str which consists of words and spaces,
return the length of the last word in the string.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def length_of_last_word(s):
    """
    Traverse from end, skip trailing spaces, count last word.
    TC: O(n), SC: O(1)
    """
    i = len(s) - 1
    length = 0

    # Skip trailing spaces
    while i >= 0 and s[i] == " ":
        i -= 1

    # Count the length of the last word
    while i >= 0 and s[i] != " ":
        length += 1
        i -= 1

    return length


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("Welcome to DSA", 3),
        (" My pet is fluffy  ", 6),
        ("singleword", 10),
        ("   ", 0),
        ("", 0),
        ("a b c d", 1),
        ("endswithspace ", 13),
    ]

    for s, expected in test_cases:
        result = length_of_last_word(s)
        print(f"Input: \"{s}\" | Output: {result} | Expected: {expected}")
