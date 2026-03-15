# Sliding window: TC: O(n), SC: O(1)
def longest_char_replacement(s, k):
    """
    Finds the length of the longest substring with the same letter after at most k replacements.
    :param s: The input string (uppercase English letters).
    :param k: The maximum number of allowed replacements.
    :return: The length of the longest valid substring.
    """
    char_count = [0] * 26
    max_length = 0
    max_char_frequency = 0
    left = 0

    for right in range(len(s)):
        char_count[ord(s[right]) - 65] += 1
        max_char_frequency = max(max_char_frequency, char_count[ord(s[right]) - 65])
        while (right - left + 1 - max_char_frequency) > k:
            char_count[ord(s[left]) - 65] -= 1
            left += 1
        max_length = max(max_length, right - left + 1)

    return max_length


# Test cases
test_cases = [
    {"s": "AAABABBAA", "k": 2, "expected": 6},
    {"s": "BBBB", "k": 2, "expected": 4},
    {"s": "AABABBA", "k": 1, "expected": 4},
    {"s": "ABAB", "k": 2, "expected": 4},
    {"s": "ABCDE", "k": 1, "expected": 2},
]

for tc in test_cases:
    result = longest_char_replacement(tc["s"], tc["k"])
    print(f'Input: "{tc["s"]}", k={tc["k"]} | Output: {result} | Expected: {tc["expected"]}')
