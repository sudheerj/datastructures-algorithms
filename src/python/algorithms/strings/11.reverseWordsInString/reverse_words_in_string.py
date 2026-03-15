"""
Reverse Words in a String

Given an input string str, return a string of the words in reverse order,
concatenated by a single space, without extra spaces.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def reverse_words_in_string(s):
    """
    Split, reverse, and join approach.
    TC: O(n), SC: O(n)
    """
    return " ".join(s.split()[::-1])


def reverse_words_in_string_manual(s):
    """
    Two-pointer swap approach.
    TC: O(n), SC: O(n)
    """
    words = s.split()
    left, right = 0, len(words) - 1
    while left < right:
        words[left], words[right] = words[right], words[left]
        left += 1
        right -= 1
    return " ".join(words)


def reverse_words_in_string_iteration(s):
    """
    Backward iteration approach.
    TC: O(n), SC: O(n)
    """
    words = s.split()
    result = ""

    for i in range(len(words) - 1, -1, -1):
        result += words[i] + " "

    return result[:-1] if result else ""


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("It is fun to learn DSA", "DSA learn to fun is It"),
        ("  hello DSA  ", "DSA hello"),
        ("single", "single"),
        ("   ", ""),
        ("", ""),
        ("a b  c   d", "d c b a"),
    ]

    for s, expected in test_cases:
        result = reverse_words_in_string(s)
        manual = reverse_words_in_string_manual(s)
        iteration = reverse_words_in_string_iteration(s)
        print(f"Input: \"{s}\" | Output: \"{result}\" | Manual: \"{manual}\" | Iteration: \"{iteration}\" | Expected: \"{expected}\"")
