"""
Pangram Checker

Given a string, determine whether it is a pangram (contains every letter
of the English alphabet at least once).

Time Complexity: O(n)
Space Complexity: O(1)
"""


def is_pangram(s):
    """
    Uses a set to track unique alphabet characters.
    TC: O(n), SC: O(1)
    """
    alphabet_set = set()

    for ch in s.lower():
        if "a" <= ch <= "z":
            alphabet_set.add(ch)

    return "pangram" if len(alphabet_set) == 26 else "not pangram"


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("The quick brown fox jumps over the lazy dog", "pangram"),
        ("Hello World", "not pangram"),
        ("A quick movement of the enemy will jeopardize five gunboats", "not pangram"),
        ("Sphinx of black quartz, judge my vow", "pangram"),
        ("This sentence is not a pangram", "not pangram"),
    ]

    for s, expected in test_cases:
        result = is_pangram(s)
        print(f"Input: \"{s}\" | Output: \"{result}\" | Expected: \"{expected}\"")
