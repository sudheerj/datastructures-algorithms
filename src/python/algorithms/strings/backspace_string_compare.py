def backspace_compare(s: str, t: str) -> bool:
    def next_char_index(str_, idx):
        skip = 0
        while idx >= 0:
            if str_[idx] == '#':
                skip += 1
            elif skip > 0:
                skip -= 1
            else:
                return idx
            idx -= 1
        return -1

    i, j = len(s) - 1, len(t) - 1
    while i >= 0 or j >= 0:
        i = next_char_index(s, i)
        j = next_char_index(t, j)
        if i < 0 or j < 0:
            return i == j
        if s[i] != t[j]:
            return False
        i -= 1
        j -= 1
    return True

if __name__ == "__main__":
    test_cases = [
        ("ab#c", "ad#c"),
        ("ab##", "c#d#"),
        ("a#c", "b"),
        ("a##c", "#a#c"),
        ("xywrrmp", "xywrrmu#p"),
        ("", ""),
        ("a#", ""),
        ("abc#d", "abzz##d"),
        ("bxj##tw", "bxo#j##tw"),
        ("nzp#o#g", "b#nzp#o#g"),
    ]
    expected = [True, True, False, True, True, True, True, True, True, True]
    for i, ((s, t), exp) in enumerate(zip(test_cases, expected)):
        result = backspace_compare(s, t)
        status = "PASS" if result == exp else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {exp} | {status}")
