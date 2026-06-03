def max_power(s):
    if not s:
        return 0
    max_streak = 1
    current = 1
    for i in range(1, len(s)):
        if s[i] == s[i-1]:
            current += 1
        else:
            current = 1
        max_streak = max(max_streak, current)
    return max_streak

if __name__ == "__main__":
    tests = ["leetcode", "abbcccddddeeeeedcba", "triplepillooooow", "hooraaaaaaaaaaay", "tourist", "", "a"]
    expected = [2, 5, 5, 11, 1, 0, 1]
    for i, s in enumerate(tests):
        result = max_power(s)
        status = "PASS" if result == expected[i] else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {expected[i]} | {status}")
