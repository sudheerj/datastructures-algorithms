# First Unique Character in a String (LC 387)
# Approach 1: frequency array  TC: O(n)  SC: O(1)
# Approach 2: frequency map    TC: O(n)  SC: O(n)


def first_uniq_char1(s: str) -> int:
    count = [0] * 26
    for ch in s:
        count[ord(ch) - ord('a')] += 1
    for i, ch in enumerate(s):
        if count[ord(ch) - ord('a')] == 1:
            return i
    return -1


def first_uniq_char2(s: str) -> int:
    char_count: dict[str, int] = {}
    for ch in s:
        char_count[ch] = char_count.get(ch, 0) + 1
    for i, ch in enumerate(s):
        if char_count[ch] == 1:
            return i
    return -1


if __name__ == "__main__":
    test_cases = [
        ("leetcode",      0),
        ("loveleetcode",  2),
        ("zeep",          0),
        ("mama",         -1),
        ("aabb",         -1),
        ("z",             0),
    ]

    print("--- Approach 1: Frequency Array ---")
    for s, expected in test_cases:
        result = first_uniq_char1(s)
        status = "PASS" if result == expected else "FAIL"
        print(f'[{status}] str="{s}" result={result} expected={expected}')

    print("--- Approach 2: Frequency Map ---")
    for s, expected in test_cases:
        result = first_uniq_char2(s)
        status = "PASS" if result == expected else "FAIL"
        print(f'[{status}] str="{s}" result={result} expected={expected}')
