def string_shift(s, shift):
    net_shift = 0
    for direction, amount in shift:
        if direction == 0:
            net_shift -= amount
        else:
            net_shift += amount
    n = len(s)
    net_shift = (net_shift % n + n) % n
    return s[-net_shift:] + s[:-net_shift] if net_shift else s

if __name__ == "__main__":
    test_strings = ["abc", "abcdefg", "x", "hello", "rotation"]
    test_shifts = [
        [[0,1],[1,2]],
        [[1,1],[1,1],[0,2],[1,3]],
        [[0,100]],
        [[1,5]],
        [[0,3],[1,4]]
    ]
    expected = ["cab", "efgabcd", "x", "hello", "tionrota"]
    for i in range(len(test_strings)):
        result = string_shift(test_strings[i], test_shifts[i])
        status = "PASS" if result == expected[i] else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {expected[i]} | {status}")
