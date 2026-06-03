def smallest_string(s: str) -> str:
    arr = list(s)
    n = len(arr)
    i = 0
    while i < n and arr[i] == 'a':
        i += 1
    if i == n:
        arr[-1] = 'z'
        return ''.join(arr)
    while i < n and arr[i] != 'a':
        arr[i] = chr(ord(arr[i]) - 1)
        i += 1
    return ''.join(arr)

if __name__ == "__main__":
    tests = [
        ("abcde", "aabcd", "aabcd"),
        ("aabc", "aabc", "aaab"),
        ("aaaa", "aaaa", "aaaz"),
        ("bca", "aca", "aba"),
        ("azaz", "azaz", "ayaz"),
        ("a", "a", "z"),
        ("b", "b", "a"),
        ("ab", "ab", "aa"),
        ("ba", "ba", "aa"),
    ]
    for i, (input_str, _, expected) in enumerate(tests, 1):
        result = smallest_string(input_str)
        status = "PASS" if result == expected else "FAIL"
        print(f"Test {i} | Output: {result} | Expected: {expected} | {status}")
