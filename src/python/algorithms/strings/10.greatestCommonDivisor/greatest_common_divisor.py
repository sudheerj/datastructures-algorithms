"""
Greatest Common Divisor of Strings

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Time Complexity: O(n + m)
Space Complexity: O(n + m)
"""
from math import gcd


def gcd_of_strings(str1, str2):
    """
    Euclidean algorithm approach.
    TC: O(n + m), SC: O(n + m)
    """
    if str1 + str2 != str2 + str1:
        return ""
    gcd_length = gcd(len(str1), len(str2))
    return str1[:gcd_length]


def gcd_of_strings_brute_force(str1, str2):
    """
    Brute-force approach checking all possible divisor lengths.
    TC: O(min(n, m) * (n + m)), SC: O(n + m)
    """
    min_len = min(len(str1), len(str2))
    for length in range(min_len, 0, -1):
        if len(str1) % length == 0 and len(str2) % length == 0:
            candidate = str1[:length]
            if (candidate * (len(str1) // length) == str1 and
                    candidate * (len(str2) // length) == str2):
                return candidate
    return ""


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("AB", "AB", "AB"),
        ("ABCABCABC", "ABCABC", "ABC"),
        ("ABABAB", "AB", "AB"),
        ("LEET", "CODE", ""),
        ("AAAAAA", "AA", "AA"),
        ("XYZ", "XYZXYZ", "XYZ"),
        ("A", "A", "A"),
        ("", "", ""),
    ]

    for str1, str2, expected in test_cases:
        result = gcd_of_strings(str1, str2)
        brute = gcd_of_strings_brute_force(str1, str2)
        print(f"Input: \"{str1}\", \"{str2}\" | GCD: \"{result}\" | Brute: \"{brute}\" | Expected: \"{expected}\"")
