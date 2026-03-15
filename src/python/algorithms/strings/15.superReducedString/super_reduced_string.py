"""
Super Reduced String

Reduce a string by repeatedly removing pairs of adjacent identical characters
until no more can be removed.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def super_reduced_string(s):
    """
    Stack-based approach to remove adjacent duplicates.
    TC: O(n), SC: O(n)
    """
    stack = []
    for char in s:
        if stack and stack[-1] == char:
            stack.pop()
        else:
            stack.append(char)
    return "".join(stack) if stack else "Empty String"


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("aaabccddd", "abd"),
        ("aa", "Empty String"),
        ("baab", "Empty String"),
        ("abc", "abc"),
    ]

    for s, expected in test_cases:
        result = super_reduced_string(s)
        print(f"Input: \"{s}\" | Output: \"{result}\" | Expected: \"{expected}\"")
