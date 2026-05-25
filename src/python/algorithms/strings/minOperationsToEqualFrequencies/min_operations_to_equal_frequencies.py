def min_ops_to_equal_frequencies(s: str) -> int:
    # Approach: Frequency Counting + Try All Target Frequencies TC: O(n) SC: O(1)
    freq_count = [0] * 26
    for ch in s:
        freq_count[ord(ch) - ord('a')] += 1

    max_freq = max(freq_count)
    ans = float('inf')

    for target in range(1, max_freq + 1):
        ops = 0
        for freq in freq_count:
            if freq == 0:
                continue
            if freq > target:
                ops += freq - target    # delete excess
            elif freq < target:
                ops += freq             # delete all occurrences
            # freq == target: 0 ops needed
        ans = min(ans, ops)

    return ans


if __name__ == "__main__":
    tests = [
        ("abc",       0),
        ("aab",       1),
        ("aabbc",     1),
        ("aaabbc",    2),
        ("aaabbbccc", 0),
    ]

    for s, expected in tests:
        result = min_ops_to_equal_frequencies(s)
        status = "[PASS]" if result == expected else "[FAIL]"
        print(f"{status} input=\"{s}\" result={result} expected={expected}")
