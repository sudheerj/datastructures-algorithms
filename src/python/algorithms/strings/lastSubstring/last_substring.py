# Two-pointer string comparison  TC: O(n) SC: O(1)

def last_substring(s):
    n = len(s)
    i = 0   # current best suffix start
    j = 1   # challenger suffix start
    k = 0   # comparison offset

    while j + k < n:
        if s[i + k] == s[j + k]:
            k += 1
        elif s[i + k] < s[j + k]:   # challenger is better
            i = max(i + k + 1, j)
            j = i + 1
            k = 0
        else:                        # current best is better
            j = j + k + 1
            k = 0

    return s[i:]


if __name__ == "__main__":
    test_cases = [
        ("abab",     "bab"),
        ("leetcode", "tcode"),
        ("cacacb",   "cb"),
        ("zz",       "zz"),
        ("abcde",    "e"),
    ]

    for s, expected in test_cases:
        result = last_substring(s)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
