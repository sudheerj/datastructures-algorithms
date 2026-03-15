"""
Mars Exploration

A rover on Mars sends a repeated "SOS" message, but some letters may be altered
during transmission. Count the number of altered letters.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def mars_exploration(s):
    """
    Compares each character against the expected "SOS" pattern.
    TC: O(n), SC: O(1)
    """
    altered_count = 0
    expected = "SOS"

    for i in range(len(s)):
        if s[i] != expected[i % 3]:
            altered_count += 1

    return altered_count


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("SOSSPSSQSSOR", 3),
        ("SOSSOT", 1),
        ("SOSSOSSOS", 0),
        ("SSSSSS", 2),
    ]

    for s, expected in test_cases:
        result = mars_exploration(s)
        print(f"Input: \"{s}\" | Output: {result} | Expected: {expected}")
