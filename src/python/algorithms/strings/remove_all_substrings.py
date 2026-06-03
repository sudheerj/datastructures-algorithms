def remove_occurrences(s, part):
    m = len(part)
    result = []
    for ch in s:
        result.append(ch)
        if len(result) >= m and ''.join(result[-m:]) == part:
            del result[-m:]
    return ''.join(result)

if __name__ == "__main__":
    tests = [
        ("daabcbaabcbc", "abc"),
        ("axxxxyyyyb", "xy"),
        ("aabababa", "aba"),
        ("aaaaa", "aa"),
        ("abcabcabc", "abc"),
        ("", "a"),
        ("abc", "d")
    ]
    expected = ["dab", "axxxxyyyyb", "ba", "a", "", "", "abc"]
    for i, (s, part) in enumerate(tests):
        result = remove_occurrences(s, part)
        status = "PASS" if result == expected[i] else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {expected[i]} | {status}")
