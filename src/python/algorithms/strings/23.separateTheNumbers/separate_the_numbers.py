"""
Separate the Numbers

Determine if a numeric string can be split into a sequence of consecutive
increasing numbers.

Time Complexity: O(n^2)
Space Complexity: O(n)
"""


def separate_the_numbers(s):
    """
    Tries all possible starting number lengths and checks for consecutive sequence.
    TC: O(n^2), SC: O(n)
    """
    length = len(s)

    for i in range(1, length // 2 + 1):
        first_num = int(s[:i])
        # Leading zeros are not allowed
        if s[0] == "0":
            continue
        sequence = str(first_num)

        num = first_num
        while len(sequence) < length:
            num += 1
            sequence += str(num)

        if sequence == s:
            return f"YES {s[:i]}"

    return "NO"


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("1234", "YES 1"),
        ("91011", "YES 9"),
        ("99100", "YES 99"),
        ("101103", "NO"),
        ("010203", "NO"),
        ("13", "NO"),
    ]

    for s, expected in test_cases:
        result = separate_the_numbers(s)
        print(f"Input: \"{s}\" | Output: \"{result}\" | Expected: \"{expected}\"")
