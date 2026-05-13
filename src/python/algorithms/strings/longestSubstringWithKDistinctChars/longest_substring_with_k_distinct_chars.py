# Longest Substring With K Distinct Characters
# Given a string and an integer k, find the length of the longest substring
# that contains at most k distinct characters.
# TC: O(n), SC: O(k)

def longest_substring_with_k_distinct(s: str, k: int) -> int:
    if not s or k == 0:
        return 0
    char_freq = {}
    max_length = 0
    left = 0

    for right in range(len(s)):
        char_freq[s[right]] = char_freq.get(s[right], 0) + 1

        while len(char_freq) > k:
            char_freq[s[left]] -= 1
            if char_freq[s[left]] == 0:
                del char_freq[s[left]]
            left += 1

        max_length = max(max_length, right - left + 1)

    return max_length


# Test cases
inputs   = ["araaci", "araaci", "cbbebi", "aabbcc", "abc", "abc", "", "aaa", "a", "abaccc"]
ks       = [2,        1,        3,        2,        3,     1,    2,  0,   1,   2]
expected = [4,        2,        5,        4,        3,     1,    0,  0,   1,   4]

for i in range(len(inputs)):
    result = longest_substring_with_k_distinct(inputs[i], ks[i])
    status = "✓" if result == expected[i] else f"✗ (expected {expected[i]})"
    print(f'"{inputs[i]}", k={ks[i]} => {result} {status}')
