# Two pointers  TC: O(n) SC: O(n)
def add_spaces(s, spaces):
    result = []
    j = 0
    for i, ch in enumerate(s):
        if j < len(spaces) and i == spaces[j]:
            result.append(' ')
            j += 1
        result.append(ch)
    return ''.join(result)


# Brute force  TC: O(n*k) SC: O(n)
def add_spaces_brute(s, spaces):
    result = s
    shift = 0
    for space in spaces:
        index = space + shift
        result = result[:index] + ' ' + result[index:]
        shift += 1
    return result


if __name__ == "__main__":
    test_cases = [
        ("LeetcodeHelpsMeLearn", [8, 13, 15], "Leetcode Helps Me Learn"),
        ("icodeinpython",        [1, 6, 8],   "i code in python"),
        ("spacing",              [],           "spacing"),
        ("ab",                   [1],          "a b"),
        ("hello",                [1, 2, 3, 4], "h e l l o"),
    ]

    for s, spaces, expected in test_cases:
        r1 = add_spaces(s, spaces)
        r2 = add_spaces_brute(s, spaces)
        s1 = "PASS" if r1 == expected else "FAIL"
        s2 = "PASS" if r2 == expected else "FAIL"
        print(f"[{s1}] twoPointers result={r1} expected={expected}")
        print(f"[{s2}] bruteForce  result={r2} expected={expected}")
