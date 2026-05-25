# Two pointers  TC: O(n) SC: O(1)
def compress(chars):
    read = 0
    write = 0

    while read < len(chars):
        current = chars[read]
        count = 0

        while read < len(chars) and chars[read] == current:
            read += 1
            count += 1

        chars[write] = current
        write += 1

        if count > 1:
            for ch in str(count):
                chars[write] = ch
                write += 1

    return write


if __name__ == "__main__":
    test_cases = [
        (['a','a','b','b','c','c','c'],                          6, ['a','2','b','2','c','3']),
        (['a'],                                                   1, ['a']),
        (['a','b','b','b','b','b','b','b','b','b','b','b','b'],  4, ['a','b','1','2']),
        (['a','a','a','a','a','a','a','a','a','a'],              3, ['a','1','0']),
        (['a','b','c'],                                          3, ['a','b','c']),
    ]

    for chars, expected_len, expected_chars in test_cases:
        result = compress(chars)
        result_chars = chars[:result]
        status = "PASS" if result == expected_len and result_chars == expected_chars else "FAIL"
        print(f"[{status}] result={result} chars={result_chars} expected={expected_len} expectedChars={expected_chars}")
