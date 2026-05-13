# Count Substrings With K Frequency Characters
# Given a string and an integer k, count substrings where at least one
# character appears at least k times.
# TC: O(n), SC: O(1)

def count_substrings_with_k_frequency_chars(s: str, k: int) -> int:
    n = len(s)
    char_frequency = [0] * 26
    left = right = result = 0

    while right < n:
        right_char = s[right]
        char_frequency[ord(right_char) - ord('a')] += 1

        while char_frequency[ord(right_char) - ord('a')] >= k:
            result += n - right
            left_char = s[left]
            char_frequency[ord(left_char) - ord('a')] -= 1
            left += 1

        right += 1

    return result


# Test cases
inputs   = ["aabb",  "aaaa", "abc", "aab", "abbc", "aabbc", "abc", "aaabbb", "a", "a"]
ks       = [2,       2,      2,     2,     2,      2,       1,     3,         1,   2]
expected = [5,       6,      0,     2,     4,      8,       6,     7,          1,   0]

for i in range(len(inputs)):
    result = count_substrings_with_k_frequency_chars(inputs[i], ks[i])
    status = "✓" if result == expected[i] else f"✗ (expected {expected[i]})"
    print(f'"{inputs[i]}", k={ks[i]} => {result} {status}')
