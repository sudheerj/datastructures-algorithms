"""
Minimum Number (Strong Password)

Given a password of length n, find the minimum number of characters
to add to make it a strong password.
A strong password has at least 6 characters and contains at least one digit,
one lowercase letter, one uppercase letter, and one special character.

Time Complexity: O(n)
Space Complexity: O(1)
"""
import re


def minimum_number(n, password):
    """
    Checks for missing character types and minimum length.
    TC: O(n), SC: O(1)
    """
    has_digit = bool(re.search(r'[0-9]', password))
    has_lower = bool(re.search(r'[a-z]', password))
    has_upper = bool(re.search(r'[A-Z]', password))
    has_special = bool(re.search(r'[!@#$%^&*()\-+]', password))

    missing_types = 0
    if not has_digit:
        missing_types += 1
    if not has_lower:
        missing_types += 1
    if not has_upper:
        missing_types += 1
    if not has_special:
        missing_types += 1

    return max(missing_types, 6 - n)


# Test cases
if __name__ == "__main__":
    test_cases = [
        (3, "Ab1", 3),
        (4, "4700", 3),
        (5, "aB1@", 1),
        (6, "aB1@xyz", 0),
    ]

    for n, password, expected in test_cases:
        result = minimum_number(n, password)
        print(f"Input: n={n}, password=\"{password}\" | Output: {result} | Expected: {expected}")
