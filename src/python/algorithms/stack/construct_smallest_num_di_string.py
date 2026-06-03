def smallest_number(pattern):
    result = []
    stack = []
    n = len(pattern)
    for i in range(n+1):
        stack.append(i+1)
        if i == n or (i < n and pattern[i] == 'I'):
            while stack:
                result.append(str(stack.pop()))
    return ''.join(result)

if __name__ == "__main__":
    patterns = ["IIIDIDDD", "D", "I", "DDI", "IDID", ""]
    expected = ["123549876", "21", "12", "3214", "13254", "1"]
    for i, pat in enumerate(patterns):
        result = smallest_number(pat)
        status = "PASS" if result == expected[i] else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {expected[i]} | {status}")
