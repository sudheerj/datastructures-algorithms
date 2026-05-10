"""
Palindrome Number

Given an integer x, return True if x is a palindrome, False otherwise.

Approach: Reverse all digits, compare with original.
TC: O(log10 n)  SC: O(1)
"""


def is_palindrome(num: int) -> bool:
    if num < 0:
        return False

    original = num
    reverse = 0

    while num > 0:
        reverse = reverse * 10 + num % 10
        num //= 10

    return original == reverse


if __name__ == "__main__":
    test_cases = [
        (121,   True,  "3-digit palindrome"),
        (-121,  False, "negative number"),
        (10,    False, "trailing zero"),
        (0,     True,  "zero"),
        (12321, True,  "5-digit odd palindrome"),
        (1221,  True,  "4-digit even palindrome"),
        (123,   False, "not a palindrome"),
    ]

    for num, expected, label in test_cases:
        result = is_palindrome(num)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {num} → {result} (expected {expected})")
