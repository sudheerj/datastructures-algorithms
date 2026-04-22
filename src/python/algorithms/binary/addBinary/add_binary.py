def add_binary(a, b):
    result = []
    i, j, carry = len(a) - 1, len(b) - 1, 0
    while i >= 0 or j >= 0 or carry:
        curr = carry
        if i >= 0:
            curr += int(a[i])
            i -= 1
        if j >= 0:
            curr += int(b[j])
            j -= 1
        result.append(str(curr % 2))
        carry = curr // 2
    return ''.join(reversed(result))

if __name__ == "__main__":
    test_cases = [
        ("11", "1", "100"),
        ("1010", "1011", "10101"),
        ("0", "0", "0"),
        ("1", "0", "1"),
        ("111", "111", "1110"),
        ("", "1", "1"),
        ("1", "", "1"),
        ("", "", ""),
    ]
    for i, (a, b, expected) in enumerate(test_cases, 1):
        result = add_binary(a, b)
        print(f"Test {i}: add_binary({a!r}, {b!r}) = {result!r} | Expected: {expected!r} | {'PASS' if result == expected else 'FAIL'}")
