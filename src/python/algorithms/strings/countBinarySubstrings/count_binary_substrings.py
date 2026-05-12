"""
Count Binary Substrings (LeetCode 696)

Return the number of substrings with equal consecutive 0s and 1s.

Approach: Group Counting
TC: O(n)  SC: O(1)
"""


def count_binary_substrings(s: str) -> int:
    prev = 0
    curr = 1
    count = 0

    for i in range(1, len(s)):
        if s[i] == s[i - 1]:
            curr += 1
        else:
            count += min(prev, curr)
            prev = curr
            curr = 1

    count += min(prev, curr)
    return count


if __name__ == "__main__":
    test_cases = [
        ("00110011", 6, 'groups [2,2,2,2]'),
        ("10101",    4, 'groups [1,1,1,1,1]'),
        ("00011",    2, 'groups [3,2]'),
        ("0",        0, 'single char'),
        ("01",       1, 'groups [1,1]'),
        ("000111",   3, 'groups [3,3]'),
    ]

    for s, expected, label in test_cases:
        result = count_binary_substrings(s)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] \"{s}\" ({label}): {result} (expected {expected})")
