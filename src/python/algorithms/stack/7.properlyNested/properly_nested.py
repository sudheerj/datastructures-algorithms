"""
Properly Nested Parentheses

Given a string consisting of '(' and ')' characters, determine whether
the parentheses are properly nested. Return 1 if properly nested, 0 otherwise.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def is_properly_nested(s):
    """
    Counter-based approach for single type of brackets.
    TC: O(n), SC: O(1)
    """
    stack_count = 0

    for ch in s:
        if ch == "(":
            stack_count += 1
        elif ch == ")":
            if stack_count == 0:
                return 0
            stack_count -= 1

    return 1 if stack_count == 0 else 0


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("(()(())())", 1),
        ("())", 0),
        ("(", 0),
        ("", 1),
    ]

    for s, expected in test_cases:
        result = is_properly_nested(s)
        print(f"Input: \"{s}\" | Output: {result} | Expected: {expected}")
