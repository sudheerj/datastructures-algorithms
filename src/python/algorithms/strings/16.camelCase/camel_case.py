"""
CamelCase

Given a camelCase string, count the number of words in it.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def camel_case_count(s):
    """
    Counts words in a camelCase string by counting uppercase letters.
    TC: O(n), SC: O(1)
    """
    if len(s) == 0:
        return 0

    count = 1
    for char in s:
        if "A" <= char <= "Z":
            count += 1
    return count


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("saveChangesInTheEditor", 5),
        ("oneTwoThree", 3),
        ("thisIsCamelCase", 4),
        ("", 0),
        ("singleword", 1),
    ]

    for s, expected in test_cases:
        result = camel_case_count(s)
        print(f"Input: \"{s}\" | Output: {result} | Expected: {expected}")
