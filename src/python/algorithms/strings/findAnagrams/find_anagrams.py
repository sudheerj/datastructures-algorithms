# Find All Anagrams in a String
# TC: O(n)  SC: O(1) — two fixed-size arrays of 26


def find_anagrams(s: str, p: str) -> list[int]:
    result = []
    if len(s) < len(p):
        return result

    p_count = [0] * 26
    s_count = [0] * 26

    for ch in p:
        p_count[ord(ch) - ord('a')] += 1

    # build first window
    for ch in s[:len(p)]:
        s_count[ord(ch) - ord('a')] += 1

    if p_count == s_count:
        result.append(0)

    for i in range(len(p), len(s)):
        s_count[ord(s[i]) - ord('a')] += 1
        s_count[ord(s[i - len(p)]) - ord('a')] -= 1
        if p_count == s_count:
            result.append(i - len(p) + 1)

    return result


if __name__ == "__main__":
    test_cases = [
        ("cbaebabacd", "abc", [0, 6]),
        ("abab",       "ab",  [0, 1, 2]),
        ("af",         "be",  []),
        ("aa",         "bb",  []),
        ("a",          "a",   [0]),
        ("baa",        "aa",  [1]),
    ]

    for s, p, expected in test_cases:
        result = find_anagrams(s, p)
        status = "PASS" if result == expected else "FAIL"
        print(f'[{status}] s="{s}" p="{p}" result={result} expected={expected}')
