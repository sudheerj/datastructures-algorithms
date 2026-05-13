"""
Count Number of Homogeneous Substrings (LeetCode 1759)

Return the number of homogeneous substrings modulo 10^9 + 7.

Approach: Streak Counting
TC: O(n)  SC: O(1)
"""

MOD = 1_000_000_007


def count_homogenous_substrings(s: str) -> int:
    count = 0
    streak = 1

    for i in range(1, len(s)):
        if s[i] == s[i - 1]:
            streak += 1
        else:
            streak = 1
        count = (count + streak) % MOD

    return (count + 1) % MOD


if __name__ == "__main__":
    test_cases = [
        ("abbcccaa", 13, "groups a(1)+b(2)+c(3)+a(2)"),
        ("xy",        2, "groups x(1)+y(1)"),
        ("zzzzz",    15, "single group z(5)"),
        ("a",         1, "single char"),
        ("aaa",       6, "single group a(3)"),
        ("aab",       4, "groups a(2)+b(1)"),
    ]

    for s, expected, label in test_cases:
        result = count_homogenous_substrings(s)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] \"{s}\" ({label}): {result} (expected {expected})")
