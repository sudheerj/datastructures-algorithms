# Stack with (char, count) pairs  TC: O(n) SC: O(n)
def remove_duplicates(s, k):
    stack = []  # each entry: [char, count]

    for ch in s:
        if stack and stack[-1][0] == ch:
            stack[-1][1] += 1
            if stack[-1][1] == k:
                stack.pop()
        else:
            stack.append([ch, 1])

    return "".join(ch * count for ch, count in stack)


if __name__ == "__main__":
    test_cases = [
        ("abcd",                   2, "abcd"),
        ("deeedbbcccbdaa",         3, "aa"),
        ("pbbcggttciiippooaais",   2, "ps"),
        ("aabbaa",                 2, ""),
        ("abcddcba",               2, ""),
    ]

    for s, k, expected in test_cases:
        result = remove_duplicates(s, k)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
